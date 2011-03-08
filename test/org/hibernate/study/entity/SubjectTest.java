package org.hibernate.study.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.hibernate.study.util.HibernateUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubjectTest {
	private static String key;

	@BeforeClass
	public static void create() {
		Subject subject = generateSubject();
		HibernateUtil.save(subject);
		key = subject.getId();
	}

	@Test
	public void testAddSubject() {
		Subject subject = generateSubject();
		HibernateUtil.save(subject);
		Subject s = (Subject) HibernateUtil.get(Subject.class, subject.getId());
		assertEquals(subject.getId(), s.getId());
	}

	@Test(expected = LazyInitializationException.class)
	public void testLazyByLoad() {
		Subject subject = generateSubject();
		HibernateUtil.save(subject);
		Subject s = (Subject) HibernateUtil.load(Subject.class, subject.getId());
		s.getName();
	}

	@Test
	public void testLazyByGet() {
		Subject subject = generateSubject();
		HibernateUtil.save(subject);
		Subject s = (Subject) HibernateUtil.get(Subject.class, subject.getId());
		assertNotNull(s.getName());
	}

	@Test
	public void testLoad() {
		Subject s = (Subject) HibernateUtil.load(Subject.class, "InvalidKey");
		assertNotNull(s);
	}

	@Test
	public void testGet() {
		Subject s = (Subject) HibernateUtil.get(Subject.class, "InvalidKey");
		assertNull(s);
	}

	@Test(expected=StaleObjectStateException.class)
	public void testVersion() {
		Session s1 = HibernateUtil.getSessionFactory().openSession();
		Session s2 = HibernateUtil.getSessionFactory().openSession();
		
		Subject e1 = (Subject) s1.get(Subject.class, key);
		Subject e2 = (Subject) s2.get(Subject.class, key);
		
		Transaction tr1 = s1.beginTransaction();
		e1.setName("changed by java");
		tr1.commit();
		s1.close();
		
		Transaction tr2 = s2.beginTransaction();
		e2.setName("changed by e1");
		tr2.commit();
		s2.close();
	}

	private static Subject generateSubject() {
		Subject subject = new Subject();
		subject.setName("sam");
		subject.setTitle("sam's title");
		return subject;
	}
}
