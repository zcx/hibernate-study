package org.hibernate.study.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate工具类，可以根据xml文件中的entity.package属性自动的添加有带有javax.persistence.Entity注解的实体类
 * @author sam
 *
 */
public class HibernateUtil {
	/**
	 * 需要添加的实体类包名，会自动添加该包下所有带有javax.persistence.Entity注解的实体类
	 */
	public static final String ENTITY_PACKAGE = "entity.package";

	/**
	 * 自定义的hibernate配置文件路径
	 */
	public static final String CONFIG_PATH = "hibernate/hibernate.cfg.xml";

	private static SessionFactory sf;

	public synchronized static SessionFactory getSessionFactory() {
		if (sf == null) {
			buildSessionFactory();
		}
		return sf;
	}

	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public static Object save(final Object object) {
		return Template.execute(new Callback() {
			@Override
			public Object execute(Session session) {
				return session.save(object);
			}
		});
	}

	public static Object load(final Class clazz, final Serializable id) {
		return Template.execute(new Callback() {
			@Override
			public Object execute(Session session) {
				return session.load(clazz, id);
			}
		});
	}

	public static Object get(final Class clazz, final Serializable id) {
		return Template.execute(new Callback() {
			@Override
			public Object execute(Session session) {
				return session.get(clazz, id);
			}
		});
	}

	private static void buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure(CONFIG_PATH);
		addAnntationClazz(config);
		sf = config.buildSessionFactory();
	}

	private static void addAnntationClazz(Configuration config) {
		String pk = config.getProperty(ENTITY_PACKAGE);
		System.out.println(pk);
		List<Class<?>> clazz = ClassUtil.getClass(pk);
		for (Class<?> class1 : clazz) {
			if (class1.getAnnotation(Entity.class) != null) {
				config.addAnnotatedClass(class1);
			}

			/**
			if (class1.getAnnotation(org.hibernate.annotations.Entity.class) != null) {
				config.addAnnotatedClass(class1);
			}
			*/
		}
	}
}

class Template {

	public static Object execute(Callback callback) {
		Session session = null;
		Object result = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			result = callback.execute(session);
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			if (session != null && session.isOpen()) {
				//				session.close();
			}
		}
		return result;
	}

}

interface Callback {
	Object execute(Session session);
}
