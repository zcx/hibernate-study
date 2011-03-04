package Metadata.subject;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaFactory;

public class SubjectFactory<P extends SubjectPackage> extends MetaFactory<P>{

	public SubjectFactory(P pkg) {
		super(pkg);
	}

	public Subject createSubject() throws Exception {
		MetaClass cls = this.getPackage().getSubjectClass();
		Subject subject = new Subject();
		subject.setType(cls);
		return subject;
	}

	public SubjectField createSubjectField() throws Exception {
		MetaClass cls = this.getPackage().getSubjectFieldClass();
		SubjectField field = new SubjectField();
		field.setType(cls);
		return field;
	}

	public SubjectSet createSubjectSet() throws Exception {
		MetaClass cls = this.getPackage().getSubjectSetClass();
		SubjectSet set = new SubjectSet();
		set.setType(cls);
		return set;
	}

	public SubjectDomain createSubjectDomain() throws Exception {
		MetaClass cls = this.getPackage().getSubjectDomainClass();
		SubjectDomain domain = new SubjectDomain();
		domain.setType(cls);
		return domain;
	}
}
