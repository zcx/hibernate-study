package Metadata.subject;

import java.util.List;

import Metadata.metamodel.MetaObject;

public interface Subject extends MetaObject{

	public void setId(String id);

	public String getId();

	public void setVersion(int version);

	public int getVersion();

	public void setName(String name);

	public String getName();

	public void setCaption(String caption);

	public String getCaption();

	public void setFields(List<SubjectField> fields);

	public List<SubjectField> getFields();

	public void setOwner(SubjectSet owner);

	public SubjectSet getOwner();

}