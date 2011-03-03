package org.hibernate.study.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.id.UUIDHexGenerator;
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
		UUIDHexGenerator uuid = new UUIDHexGenerator();
		subject.setUid((String)uuid.generate(null, null));
		subject.setName((String)uuid.generate(null, null));
		subject.setTitle((String)uuid.generate(null, null));
		return subject;
	}
}
