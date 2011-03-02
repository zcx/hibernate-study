package Metadata.subject;

import java.util.Set;

import Metadata.metamodel.MetaObject;

public interface SubjectSet extends MetaObject{

	public void setSubjects(Set<Subject> subjects);

	public Set<Subject> getSubjects();

	public void setOwner(SubjectDomain owner);

	public SubjectDomain getOwner();

}