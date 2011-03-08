package Metadata;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Metadata.metamodel.HibernateUtil;
import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaDataRepository;
import Metadata.subject.Subject;
import Metadata.subject.SubjectFactory;
import Metadata.subject.SubjectPackage;

/**
 * 测试类
 * @author classfoo
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		Test test = new Test();
		//test.doTest();
		test.doTest1();
	}

	private void doTest1() throws Exception {
		MetaDataRepository mdr = new MetaDataRepository();
		SubjectPackage pkg = mdr.getPackage(SubjectPackage.class);
		SubjectFactory factory = pkg.getFactory();
		Subject subject = factory.createSubject();
		MetaClass type = subject.getType();
		System.out.println(type);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(subject);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}
}
