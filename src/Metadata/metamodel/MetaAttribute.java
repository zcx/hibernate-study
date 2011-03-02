package Metadata.metamodel;

import java.util.List;

public interface MetaAttribute {

	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public boolean isNullable();

	public void setNullable(boolean isNullable);

	public boolean isStatic();

	public void setStatic(boolean isStatic);

	public boolean isInverseable();

	public void setInverseable(boolean isInverseable);

	public MetaClass getType();

	public void setType(MetaClass type);

	public MetaClass getOwner();

	public void setOwner(MetaClass owner);

	public List<MetaAssociation> getAssociations();

	public void setAssociations(List<MetaAssociation> associations);

	public void setVersion(int version);

	public int getVersion();

}
