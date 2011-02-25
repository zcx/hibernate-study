package Metadata;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import sample.Sample;

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
		HBObject object = new HBObject();
		session.save(object);
		List<?> result = session.createQuery("from HBObject").list();
		Sample s = (Sample) result.get(0);
		System.out.println(s.getId());
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
