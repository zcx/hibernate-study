package events;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class EventManager {
	public static void main(String[] args) {
		EventManager mgr = new EventManager();
		mgr.createAndStoreEvent("My Event", new Date());
	}

	private void createAndStoreEvent(String title, Date theDate) {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		session.save(theEvent);

		List<?> result = session.createQuery("from Event").list();
		Event e = (Event) result.get(0);
		System.out.println(e.getId());

		session.getTransaction().commit();
		sf.close();
	}

	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration().configure("/events/event-hibernate.cfg.xml");
		return conf.buildSessionFactory();
	}
}
