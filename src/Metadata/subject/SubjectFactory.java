package Metadata.subject;

import Metadata.metamodel.MetaFactory;
import Metadata.subject.impl.SubjectDomainEntity;
import Metadata.subject.impl.SubjectEntity;
import Metadata.subject.impl.SubjectFieldEntity;
import Metadata.subject.impl.SubjectSetEntity;

public class SubjectFactory extends MetaFactory{

	public Subject createSubject() {
		return new SubjectEntity();
	}

	public SubjectField createSubjectField() {
		return new SubjectFieldEntity();
	}

	public SubjectSet createSubjectSet() {
		return new SubjectSetEntity();
	}

	public SubjectDomain createSubjectDomain() {
		return new SubjectDomainEntity();
	}
}
