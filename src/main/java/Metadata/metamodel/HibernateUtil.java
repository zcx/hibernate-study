package Metadata.metamodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Configuration configuration = new Configuration();

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setConfiguration(Configuration config) {
		configuration = config;
		sessionFactory = configuration.buildSessionFactory();
	}
	
	private static Configuration getConfiguration(){
		return configuration;
	}
	
	public static void rebuildSessionFactory() throws Exception {
		synchronized (sessionFactory) {
			try {
				sessionFactory = getConfiguration().buildSessionFactory();
			}
			catch (Exception ex) {
				throw new Exception(ex);
			}
		}
	}

	public static void rebuildSessionFactory(Configuration cfg) throws Exception {
		synchronized (sessionFactory) {
			try {
				sessionFactory = cfg.buildSessionFactory();
				configuration = cfg;
			}
			catch (Exception ex) {
				throw new Exception(ex);
			}
		}
	}

	public static Session getSession() throws Exception {
		return sessionFactory.openSession();
	}
}
