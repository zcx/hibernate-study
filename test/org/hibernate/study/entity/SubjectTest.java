package org.hibernate.study.entity;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.study.util.HibernateUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubjectTest {
	private static SessionFactory factory;

	@BeforeClass
	public static void create() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Test
	public void testAddSubject() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Subject subject = generateSubject();
		session.save(subject);
		session.getTransaction().commit();
	}

	private Subject generateSubject() {
		Subject subject = new Subject();
		subject.setUid(UUID.randomUUID().toString());
		subject.setName(UUID.randomUUID().toString());
		subject.setTitle(UUID.randomUUID().toString());
		return subject;
	}
}
