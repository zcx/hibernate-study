package Metadata.metamodel;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * Basic Hibernate helper class, handles SessionFactory, Session and Transaction.
 * <p>
 * Uses a static initializer for the initial SessionFactory creation
 * and holds Session and Transactions in thread local variables. All
 * exceptions are wrapped in an unchecked Exception.
 *
 * @author christian@hibernate.org
 */
public class HibernateUtil {

	private static Configuration configuration;

	private static SessionFactory sessionFactory;

	private static final ThreadLocal threadSession = new ThreadLocal();

	private static final ThreadLocal threadTransaction = new ThreadLocal();

	private static final ThreadLocal threadInterceptor = new ThreadLocal();

	// Create the initial SessionFactory from the default configuration files
	static {
		try {
			configuration = new Configuration();
			sessionFactory = configuration.configure().buildSessionFactory();
			// We could also let Hibernate bind it to JNDI:
			// configuration.configure().buildSessionFactory()
		}
		catch (Throwable ex) {
			// We have to catch Throwable, otherwise we will miss
			// NoClassDefFoundError and other subclasses of Error
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Returns the SessionFactory used for this static class.
	 *
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		/* Instead of a static variable, use JNDI:
		SessionFactory sessions = null;
		try {
			Context ctx = new InitialContext();
			String jndiName = "java:hibernate/HibernateFactory";
			sessions = (SessionFactory)ctx.lookup(jndiName);
		} catch (NamingException ex) {
			throw new Exception(ex);
		}
		return sessions;
		*/
		return sessionFactory;
	}

	/**
	 * Returns the original Hibernate configuration.
	 *
	 * @return Configuration
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * Rebuild the SessionFactory with the static Configuration.
	 *
	 */
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

	/**
	 * Rebuild the SessionFactory with the given Hibernate Configuration.
	 *
	 * @param cfg
	 */
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

	/**
	 * Retrieves the current Session local to the thread.
	 * <p/>
	 * If no Session is open, opens a new Session for the running thread.
	 *
	 * @return Session
	 */
	public static Session getSession() throws Exception {
		Session s = (Session) threadSession.get();
		try {
			if (s == null) {
				if (getInterceptor() != null) {
					s = getSessionFactory().openSession(getInterceptor());
				}
				else {
					s = getSessionFactory().openSession();
				}
				threadSession.set(s);
			}
		}
		catch (HibernateException ex) {
			throw new Exception(ex);
		}
		return s;
	}

	/**
	 * Closes the Session local to the thread.
	 */
	public static void closeSession() throws Exception {
		try {
			Session s = (Session) threadSession.get();
			if (s != null && s.isOpen()) {
				threadSession.set(null);
				s.close();
			}
		}
		catch (HibernateException ex) {
			throw new Exception(ex);
		}
	}

	/**
	 * Start a new database transaction.
	 */
	public static void beginTransaction() throws Exception {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			if (tx == null) {
				tx = getSession().beginTransaction();
				threadTransaction.set(tx);
			}
		}
		catch (HibernateException ex) {
			throw new Exception(ex);
		}
	}

	/**
	 * Commit the database transaction.
	 */
	public static void commitTransaction() throws Exception {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
				tx.commit();
			}
			threadTransaction.set(null);
		}
		catch (HibernateException ex) {
			rollbackTransaction();
			throw new Exception(ex);
		}
	}

	/**
	 * Commit the database transaction.
	 */
	public static void rollbackTransaction() throws Exception {
		Transaction tx = (Transaction) threadTransaction.get();
		try {
			threadTransaction.set(null);
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
				tx.rollback();
			}
		}
		catch (HibernateException ex) {
			throw new Exception(ex);
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Reconnects a Hibernate Session to the current Thread.
	 *
	 * @param session The Hibernate Session to be reconnected.
	 */
	public static void reconnect(Session session) throws Exception {
		try {
			session.reconnect();
			threadSession.set(session);
		}
		catch (HibernateException ex) {
			throw new Exception(ex);
		}
	}

	/**
	 * Disconnect and return Session from current Thread.
	 *
	 * @return Session the disconnected Session
	 */
	public static Session disconnectSession() throws Exception {

		Session session = getSession();
		try {
			threadSession.set(null);
			if (session.isConnected() && session.isOpen())
				session.disconnect();
		}
		catch (HibernateException ex) {
			throw new Exception(ex);
		}
		return session;
	}

	/**
	 * Register a Hibernate interceptor with the current thread.
	 * <p>
	 * Every Session opened is opened with this interceptor after
	 * registration. Has no effect if the current Session of the
	 * thread is already open, effective on next close()/getSession().
	 */
	public static void registerInterceptor(Interceptor interceptor) {
		threadInterceptor.set(interceptor);
	}

	private static Interceptor getInterceptor() {
		Interceptor interceptor = (Interceptor) threadInterceptor.get();
		return interceptor;
	}

}
