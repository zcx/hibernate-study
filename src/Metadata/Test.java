package Metadata;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * 测试类
 * @author classfoo
 *
 */
public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.doTest();
	}

	private void doTest() {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		HBObject object1 = new HBObject();
		session.save(object1);
		HBObject object2 = new HBObject();
		session.save(object2);
		HBLink link = new HBLink();
		HBSlot slot1 = new HBSlot();
		session.save(slot1);
		link.setSlot1(slot1);
		HBSlot slot2 = new HBSlot();
		session.save(slot2);
		link.setSlot2(slot2);
		session.saveOrUpdate(link);
		List<?> result = session.createQuery("from HBObject").list();
		Iterator<?> it = result.iterator();
		while (it.hasNext()) {
			HBObject s = (HBObject) it.next();
			System.out.println(s.getId());
		}
		session.getTransaction().commit();
		sf.close();
	}

	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(HBLink.class);
		conf.addAnnotatedClass(HBObject.class);
		conf.addAnnotatedClass(HBSlot.class);
		return conf.buildSessionFactory();
	}
}
