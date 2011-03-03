package Metadata.metamodel;

import java.util.HashMap;

import org.hibernate.Session;
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
			Configuration conf = HibernateUtil.getConfiguration();
			conf.configure("/Metadata/metadata-hibernate.cfg.xml");
			MetaPackage mpkg = new MetaPackage();
			mpkg.setName(MetaPackage.class.getName());
			mpkg.loadAnnotatedClass(conf);
			SubjectPackage spkg = new SubjectPackage();
			spkg.setName(SubjectPackage.class.getName());
			spkg.loadAnnotatedClass(conf);
			DbPackage dpkg = new DbPackage();
			dpkg.setName(DbPackage.class.getName());
			dpkg.loadAnnotatedClass(conf);
			HibernateUtil.rebuildSessionFactory(conf);
			Session session = HibernateUtil.getSession();
			HibernateUtil.beginTransaction();
			try {
				session.saveOrUpdate(mpkg);
				session.saveOrUpdate(spkg);
				session.saveOrUpdate(dpkg);
				HibernateUtil.commitTransaction();
			}
			catch (Exception e) {
				HibernateUtil.rollbackTransaction();
				throw new RuntimeException(e);
			}
			finally {
				HibernateUtil.closeSession();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("inital MetaDataRepository error!", e);
		}

	}

	public <T extends MetaPackage> T getPackage(Class<T> cls) throws Exception {
		String name = cls.getName();
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		try {
			Object pkg = session.get(MetaPackage.class, name);
			return cls.cast(pkg);
		}
		catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			throw new RuntimeException(e);
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
}
