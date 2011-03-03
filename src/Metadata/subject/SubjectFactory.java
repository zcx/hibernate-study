package Metadata.subject;

import Metadata.metamodel.MetaFactory;

public class SubjectFactory extends MetaFactory{

	public Subject createSubject() {
		return new Subject();
	}

	public SubjectField createSubjectField() {
		return new SubjectField();
	}

	public SubjectSet createSubjectSet() {
		return new SubjectSet();
	}

	public SubjectDomain createSubjectDomain() {
		return new SubjectDomain();
	}
}
