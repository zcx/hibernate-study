package Metadata.subject;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaFactory;

public class SubjectFactory extends MetaFactory{
	private SubjectPackage pkg = null;
	public SubjectFactory(SubjectPackage pkg) {
		this.pkg = pkg;
	}

	public Subject createSubject() throws Exception {
		MetaClass cls = this.pkg.getSubject();
		Subject subject = new Subject();
		subject.setType(cls);
		return subject;
	}

	public SubjectField createSubjectField() throws Exception {
		MetaClass cls = this.pkg.getSubjectField();
		SubjectField field = new SubjectField();
		field.setType(cls);
		return field;
	}

	public SubjectSet createSubjectSet() throws Exception {
		MetaClass cls = this.pkg.getSubjectSet();
		SubjectSet set = new SubjectSet();
		set.setType(cls);
		return set;
	}

	public SubjectDomain createSubjectDomain() throws Exception {
		MetaClass cls = this.pkg.getSubjectDomain();
		SubjectDomain domain = new SubjectDomain();
		domain.setType(cls);
		return domain;
	}
}
