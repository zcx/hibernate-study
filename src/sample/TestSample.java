package sample;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestSample {
	public static void main(String[] args) {
		TestSample mgr = new TestSample();
		mgr.createAndStoreSample("My Sample", new Date());
	}

	private void createAndStoreSample(String title, Date theDate) {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Sample theSample = new Sample();
		theSample.setTitle(title);
		theSample.setDate(theDate);
		session.save(theSample);

		List<?> result = session.createQuery("from Sample").list();
		Sample s = (Sample) result.get(0);
		System.out.println(s.getId());

		session.getTransaction().commit();
		sf.close();
	}

	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration().configure("/sample/sample-hibernate.cfg.xml");
		return conf.buildSessionFactory();
	}
}
