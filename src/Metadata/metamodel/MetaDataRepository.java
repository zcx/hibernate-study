package Metadata.metamodel;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.db.DbPackage;
import Metadata.subject.SubjectPackage;

/**
 * 元数据库
 * @author classfoo
 *
 */
public class MetaDataRepository {

	private static HashMap<Class<?>, MetaPackage> pkgreposit = new HashMap<Class<?>, MetaPackage>();

	public MetaDataRepository() {
		try {
			Configuration conf = new Configuration();
			conf.configure("/Metadata/metadata-hibernate.cfg.xml");
			HibernateUtil.setConfiguration(conf);
			MetaPackage mpkg = new MetaPackage();
			mpkg.setUri(MetaPackage.class.getPackage().getName());
			mpkg.loadAnnotatedClass(conf);
			SubjectPackage spkg = new SubjectPackage();
			spkg.setUri(SubjectPackage.class.getPackage().getName());
			spkg.loadAnnotatedClass(conf);
			DbPackage dpkg = new DbPackage();
			dpkg.setUri(DbPackage.class.getPackage().getName());
			dpkg.loadAnnotatedClass(conf);
			HibernateUtil.rebuildSessionFactory(conf);
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			try {
				session.saveOrUpdate(mpkg);
				session.saveOrUpdate(spkg);
				session.saveOrUpdate(dpkg);
				tx.commit();
			}
			catch (Exception e) {
				tx.rollback();
				throw new RuntimeException(e);
			}
			finally {
				session.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("inital MetaDataRepository error!", e);
		}

	}

	public <T extends MetaPackage> T getPackage(Class<T> cls) throws Exception {
		String name = cls.getPackage().getName();
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Object pkg = session.get(MetaPackage.class, name);
			return cls.cast(pkg);
		}
		catch (Exception e) {
			tx.rollback();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}

	}
}
