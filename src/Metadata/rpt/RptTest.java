package Metadata.rpt;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Metadata.metamodel.HibernateUtil;
import Metadata.metamodel.MetaDataRepository;

/**
 * 这个类主要用于测试报表存储时的目录结构如何通过元数据表达
 * @author classfoo
 *
 */
public class RptTest {

	public static void main(String[] args) throws Exception {
		MetaDataRepository mdr = new MetaDataRepository();
		RptPackage pkg = mdr.getPackage(RptPackage.class);
		RptFactory<RptPackage> factory = pkg.getFactory();
		Directory group = factory.createDirectory("/", "root");
		Report report = factory.createReport(group, "rpt1.npf");
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(group);
			session.saveOrUpdate(report);
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
