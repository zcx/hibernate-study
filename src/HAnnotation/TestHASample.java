package HAnnotation;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * 测试使用jdk的Annotation映射数据库表，不使用Hibernate的映射文件，需要注意创建的Configuration可以使用AnnotationConfiguration
 */
public class TestHASample {
	public static void main(String[] args) {
		TestHASample mgr = new TestHASample();
		mgr.createAndStoreSample("My Sample", new Date());
	}

	private void createAndStoreSample(String title, Date theDate) {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		HASample theSample = new HASample();
		theSample.setTitle(title);
		theSample.setDate(theDate);
		session.save(theSample);

		List<?> result = session.createCriteria(HASample.class).list();
		HASample s = (HASample) result.get(0);
		System.out.println(s.getId());

		session.getTransaction().commit();
		sf.close();
	}

	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure("/HAnnotation/hasample-hibernate.cfg.xml");
		conf.addAnnotatedClass(HASample.class);
		return conf.buildSessionFactory();
	}
}
