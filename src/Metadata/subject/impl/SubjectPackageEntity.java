package Metadata.subject.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Metadata.metamodel.impl.MetaPackageEntity;
import Metadata.subject.SubjectPackage;

public class SubjectPackageEntity extends MetaPackageEntity implements SubjectPackage{
	public SubjectPackageEntity() {

	}
	
	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(SubjectEntity.class);
		conf.addAnnotatedClass(SubjectSetEntity.class);
		conf.addAnnotatedClass(SubjectDomainEntity.class);
		conf.addAnnotatedClass(SubjectFieldEntity.class);
		return conf.buildSessionFactory();
	}	
}
