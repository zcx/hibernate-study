package Metadata.test.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.util.HibernateUtil;

public class TestOneToOne {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(TObject.class);
		conf.addAnnotatedClass(TInstance.class);
		conf.addAnnotatedClass(TClassInstance.class);
		conf.addAnnotatedClass(TLinkInstance.class);
		HibernateUtil.setConfiguration(conf);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			TObject object = new TObject();
			session.save(object);
			TInstance instance = new TClassInstance();
			instance.setName("name");
			instance.setParentdir("/home/classfoo/classpath");
			instance.setTobj(object);
			session.save(instance);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}
}
