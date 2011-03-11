package Metadata.subject;

import javax.persistence.Entity;

import org.hibernate.cfg.Configuration;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaPackage;

@Entity
public class SubjectPackage extends MetaPackage {

	public void loadAnnotatedClass(Configuration conf) {
		conf.addAnnotatedClass(Subject.class);
		conf.addAnnotatedClass(SubjectSet.class);
		conf.addAnnotatedClass(SubjectDomain.class);
		conf.addAnnotatedClass(SubjectField.class);
		conf.addAnnotatedClass(SubjectPackage.class);
	}

	public MetaClass getSubjectDomainClass() throws Exception {
		return getMetaClassByJavaClass(SubjectDomain.class, "SubjectDomain");
	}

	public MetaClass getSubjectFieldClass() throws Exception {
		return getMetaClassByJavaClass(SubjectField.class, "SubjectField");
	}

	public MetaClass getSubjectSetClass() throws Exception {
		return getMetaClassByJavaClass(SubjectSet.class, "SubjectSet");
	}

	public MetaClass getSubjectClass() throws Exception {
		return getMetaClassByJavaClass(Subject.class, "Subject");
	}

	public SubjectFactory<SubjectPackage> getFactory() {
		return new SubjectFactory<SubjectPackage>(this);
	}
}