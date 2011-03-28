package Metadata.test;

import java.util.Map;

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
		conf.addAnnotatedClass(Software.class);
		conf.addAnnotatedClass(Version.class);
		
		HibernateUtil.setConfiguration(conf);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String id = null;
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
			
			Version version = new Version();
			session.save(version);
			Version version2 = new Version();
			session.save(version2);
			
			Software sw = new Software();
			version.setSoftware(sw);
			version.setCode("0.0.0.1");
			version2.setCode("0.0.0.2");
			version2.setSoftware(sw);
			session.saveOrUpdate(sw);
			id = sw.getId();
			
			Software sw1 = new Software();
			Version version3 = new Version();
			version3.setSoftware(sw1);
			version3.setCode("0.0.0.5");
			session.saveOrUpdate(version3);
			session.saveOrUpdate(sw1);
			
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}
		session = HibernateUtil.getSession();
		Software sw = (Software) session.get(Software.class, id);
		Map<String, Version> versions = sw.getVersions();
		System.out.println(versions.toString());
//		Man man = new Man();
//		man.excuteHQL("from Man");
	}
}
