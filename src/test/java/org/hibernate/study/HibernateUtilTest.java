package org.hibernate.study;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.study.util.HibernateUtil;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void testGetSessionFactory() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		assertNotNull(factory);
		assertNotNull(factory.getCurrentSession());
	}

}
