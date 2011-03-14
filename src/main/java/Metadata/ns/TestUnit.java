package Metadata.ns;

import junit.framework.TestCase;

import org.hibernate.cfg.Configuration;

import Metadata.ns.impl.HBRFileObjectImpl;
import Metadata.ns.impl.HBRMetaObjectImpl;
import Metadata.ns.impl.HBRNamespaceImpl;
import Metadata.ns.impl.HBROrganizationImpl;
import Metadata.ns.impl.NSPackageImpl;
import Metadata.util.HibernateUtil;

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
		
		NSPackageImpl pkg = new NSPackageImpl();
		NSFactory factory = pkg.getFactory();
		FileObject file0 = factory.createFileObject(null, "root", true);
		file0.getAbsolutePath();
		Organization org0 = factory.createOrganization(null, "税务总局", true);
//		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
//		try{
//			HBRFileObjectImpl file = new HBRFileObjectImpl(null, "root", true);
//			session.saveOrUpdate(file);
//			HBRFileObjectImpl file2 = new HBRFileObjectImpl(file, "child1", true);
//			session.saveOrUpdate(file2);
//			Namespace parent0 = file2.getParent();
//			Namespace parent1 = file2.getParent();
//			Namespace parent2 = file2.getParent();
//			Namespace parent3 = file2.getParent();
//			Namespace parent4 = file2.getParent();
//			
//			assertEquals(parent0, file);
//			HBRFileObjectImpl file3 = new HBRFileObjectImpl(file, "child1", false);
//			session.saveOrUpdate(file3);
//			HBRFileObjectImpl file4 = new HBRFileObjectImpl(file, "child4", true);
//			session.saveOrUpdate(file4);
//			HBRFileObjectImpl file5 = new HBRFileObjectImpl(file2, "child5", false);
//			session.saveOrUpdate(file5);
//			System.out.println("【file.getAbsolutePath】");
//			file.getAbsolutePath();
//			System.out.println("【org.getAbsolutePath】");
//			HBROrganizationImpl org = new HBROrganizationImpl(null, "orgroot");
//			session.saveOrUpdate(org);
//			org.getAbsolutePath();
//			tx.commit();
//		}catch(Exception e){
//			tx.rollback();
//			e.printStackTrace();
//			throw e;
//		}finally{
//			session.close();
//		}
	}
}
