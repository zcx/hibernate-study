package Metadata.subject;

import java.util.Set;

public interface SubjectSet {

	public abstract void setId(String id);

	public abstract String getId();

	public abstract void setVersion(int version);

	public abstract int getVersion();

	public abstract void setSubjects(Set<Subject> subjects);

	public abstract Set<Subject> getSubjects();

	public abstract void setOwner(SubjectDomain owner);

	public abstract SubjectDomain getOwner();

}