package Metadata.ns;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.metamodel.HibernateUtil;
import Metadata.ns.impl.HBRFileObjectImpl;
import Metadata.ns.impl.HBRMetaObjectImpl;
import Metadata.ns.impl.HBRNamespaceImpl;
import Metadata.ns.impl.HBROrganizationImpl;

public class TestUnit extends TestCase{
	@Override
	protected void setUp() throws Exception {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(HBRFileObjectImpl.class);
		conf.addAnnotatedClass(HBRMetaObjectImpl.class);
		conf.addAnnotatedClass(HBRNamespaceImpl.class);
		conf.addAnnotatedClass(HBROrganizationImpl.class);
		HibernateUtil.setConfiguration(conf);
		super.setUp();
	}
	
	public void testCreateVFSFile() throws Exception{
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try{
			HBRFileObjectImpl file = new HBRFileObjectImpl(session, null, "root", true);
			session.saveOrUpdate(file);
			HBRFileObjectImpl file2 = new HBRFileObjectImpl(session, file, "child1", true);
			session.saveOrUpdate(file2);
			HBRFileObjectImpl file3 = new HBRFileObjectImpl(session, file, "child1", false);
			session.saveOrUpdate(file3);
			HBRFileObjectImpl file4 = new HBRFileObjectImpl(session, file, "child4", true);
			session.saveOrUpdate(file4);
			HBRFileObjectImpl file5 = new HBRFileObjectImpl(session, file2, "child5", false);
			session.saveOrUpdate(file5);
			System.out.println("【file.getAbsolutePath】");
			file.getAbsolutePath();
			System.out.println("【org.getAbsolutePath】");
			HBROrganizationImpl org = new HBROrganizationImpl(session , null, "orgroot");
			session.saveOrUpdate(org);
			org.getAbsolutePath();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
	}
}
