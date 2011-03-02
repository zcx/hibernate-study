package Metadata.subject;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Metadata.metamodel.impl.MetaPackageEntity;

public class HBSubjectPackage extends MetaPackageEntity{
	public HBSubjectPackage() {

	}
	
	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(HBSubject.class);
		conf.addAnnotatedClass(HBSubjectSet.class);
		conf.addAnnotatedClass(HBSubjectDomain.class);
		conf.addAnnotatedClass(HBSubjectField.class);
		return conf.buildSessionFactory();
	}	
}
