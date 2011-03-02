package Metadata.subject;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaPackage;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SubjectPackage extends MetaPackage{
	
	public MetaClass getSubjectDomain() {
		
		return null;
	}

	public MetaClass getSubjectField() {
		return null;
	}

	public MetaClass getSubjectSet() {
		return null;
	}

	public MetaClass getSubject() {
		return null;
	}

	public SubjectFactory getFactory() {
		return null;
	}
}