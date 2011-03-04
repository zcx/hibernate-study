package org.hibernate.study.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.hibernate.LazyInitializationException;
import org.hibernate.study.util.HibernateUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubjectTest {

	@BeforeClass
	public static void create() {
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

	private Subject generateSubject() {
		Subject subject = new Subject();
		subject.setName("sam");
		subject.setTitle("sam's title");
		return subject;
	}
}
