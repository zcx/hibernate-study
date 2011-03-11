package Metadata.ns;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.metamodel.HibernateUtil;
import Metadata.ns.impl.HBRFileObjectImpl;
import Metadata.ns.impl.HBRMetaObjectImpl;
import Metadata.ns.impl.HBRNamespaceImpl;

public class TestUnit extends TestCase{
	@Override
	protected void setUp() throws Exception {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(HBRFileObjectImpl.class);
		conf.addAnnotatedClass(HBRMetaObjectImpl.class);
		conf.addAnnotatedClass(HBRNamespaceImpl.class);
		HibernateUtil.setConfiguration(conf);
		super.setUp();
	}
	
	public void testCreateVFSFile() throws Exception{
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try{
			HBRFileObjectImpl file = new HBRFileObjectImpl(session, null, "root", true);
			session.save(file);
			HBRFileObjectImpl file2 = new HBRFileObjectImpl(session, file, "child1", true);
			session.save(file2);
			HBRFileObjectImpl file3 = new HBRFileObjectImpl(session, file, "child1", false);
			session.save(file3);
			HBRFileObjectImpl file4 = new HBRFileObjectImpl(session, file, "child4", true);
			session.save(file4);
			HBRFileObjectImpl file5 = new HBRFileObjectImpl(session, file2, "child5", false);
			session.save(file5);
			file.getAbsolutePath();
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
