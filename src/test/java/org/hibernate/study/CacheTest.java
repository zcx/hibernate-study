package org.hibernate.study;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.hibernate.study.entity.Subject;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 测试Hibernate的get、load访问与缓存的关系
 * @author sam
 */
public class CacheTest {
	private static SessionFactory factory;

	@BeforeClass
	public static void beforeClass() {
		Configuration cfg = new Configuration().configure("/hibernate/hibernate.cfg.xml");
		cfg.addAnnotatedClass(Subject.class);
		factory = cfg.buildSessionFactory();
	}

	@After
	public void after() {
		factory.getCache().evictEntityRegion(Subject.class);
		factory.getStatistics().clear();
	}

	@Test
	public void testSessionGet() {
		Subject subject = generateSubject();
		assertGetMissCache(subject.getId());
		assertGetHitCache(subject.getId());
		
		factory.getCache().evictEntityRegion(Subject.class);
		assertGetMissCache(subject.getId());
	}

	/**
	 * 调用load方法的时候,hibernate一开始并没有查询二级缓存或是数据库, 而是先返回一个代理对象,
	 * 该对象只包含id,只有显示调用对象的非id属性时,比如subject.getName(),hibernate才会去二级缓存查找,
	 * 如果没命中缓存再去数据库找,数据库还找不到则抛异常.load方法会尽量推迟对象的查找工作,这是它跟get方法最大的区别. 
	 */
	@Test
	public void testSessionLoad() {
		Subject subject = generateSubject();
		assertLoadMissCache(subject.getId());
		assertLoadHitCache(subject.getId());
	}

	private Subject generateSubject() {
		Subject subject = new Subject();
		subject.setName("this is a name");
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(subject);
		session.getTransaction().commit();
		session.close();
		factory.getCache().evictEntityRegion(Subject.class);
		return subject;
	}

	private void assertGetMissCache(Serializable id) {
		Statistics stats = factory.getStatistics();
		long count = factory.getStatistics().getSecondLevelCacheMissCount();
		Session session = factory.openSession();
		session.beginTransaction();
		session.get(Subject.class, id);
		session.getTransaction().commit();
		session.close();
		Assert.assertEquals(count + 1, stats.getSecondLevelCacheMissCount());
	}

	private void assertGetHitCache(Serializable id) {
		Statistics statistics = factory.getStatistics();
		long count = statistics.getSecondLevelCacheHitCount();
		Session session = factory.openSession();
		session.beginTransaction();
		session.get(Subject.class, id);
		session.getTransaction().commit();
		session.close();
		Assert.assertEquals(count + 1, statistics.getSecondLevelCacheHitCount());
	}

	private void assertLoadMissCache(Serializable id) {
		Statistics stats = factory.getStatistics();
		long count = factory.getStatistics().getSecondLevelCacheMissCount();
		Session session = factory.openSession();
		session.beginTransaction();
		Subject u = (Subject) session.load(Subject.class, id);
		//注意如果不访问非ID时，u只是一个代理对象，不会访问二级缓存
		u.getName();
		session.getTransaction().commit();
		session.close();
		Assert.assertEquals(count + 1, stats.getSecondLevelCacheMissCount());
	}

	private void assertLoadHitCache(Serializable id) {
		Statistics statistics = factory.getStatistics();
		long count = statistics.getSecondLevelCacheHitCount();
		Session session = factory.openSession();
		session.beginTransaction();
		Subject u = (Subject) session.load(Subject.class, id);
		//注意如果不访问非ID时，u只是一个代理对象，不会访问二级缓存
		u.getName();
		session.getTransaction().commit();
		session.close();
		Assert.assertEquals(count + 1, statistics.getSecondLevelCacheHitCount());
	}
}
