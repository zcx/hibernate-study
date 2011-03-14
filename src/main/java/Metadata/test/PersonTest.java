package Metadata.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.util.HibernateUtil;

public class PersonTest {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(Man.class);
		conf.addAnnotatedClass(Person.class);
		conf.addAnnotatedClass(Woman.class);
		HibernateUtil.setConfiguration(conf);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Man man = new Man();
			session.saveOrUpdate(man);
			Man man1 = new Man();
			session.saveOrUpdate(man1);
			Man man2 = new Man();
			session.saveOrUpdate(man2);
			Man man3 = new Man();
			session.saveOrUpdate(man3);
			Man man4 = new Man();
			session.saveOrUpdate(man4);
			
			Woman woman = new Woman();
			session.saveOrUpdate(woman);
			Woman woman1 = new Woman();
			session.saveOrUpdate(woman1);
			Woman woman2 = new Woman();
			session.saveOrUpdate(woman2);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
		Man man = new Man();
		man.excuteHQL("from Man");
	}
}
