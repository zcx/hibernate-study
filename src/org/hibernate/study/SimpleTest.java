package org.hibernate.study;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.study.entity.Subject;
import org.hibernate.study.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest {
	private static Logger log = LoggerFactory.getLogger(SimpleTest.class);

	public static void main(String[] args) {
		log.debug("test");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		Subject subject = new Subject();
		subject.setUid("001");
		subject.setName("test");
		subject.setTitle("this");
		session.beginTransaction();
		session.save(subject);
		session.getTransaction().commit();
	}
}
