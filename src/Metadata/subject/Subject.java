package Metadata.subject;

import java.util.List;

public interface Subject {

	public abstract void setId(String id);

	public abstract String getId();

	public abstract void setVersion(int version);

	public abstract int getVersion();

	public abstract void setName(String name);

	public abstract String getName();

	public abstract void setCaption(String caption);

	public abstract String getCaption();

	public abstract void setFields(List<SubjectField> fields);

	public abstract List<SubjectField> getFields();

	public abstract void setOwner(SubjectSet owner);

	public abstract SubjectSet getOwner();

}