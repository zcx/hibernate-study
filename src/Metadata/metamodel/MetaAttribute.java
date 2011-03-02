package Metadata.metamodel;

import java.util.List;

public interface MetaAttribute {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract boolean isNullable();

	public abstract void setNullable(boolean isNullable);

	public abstract boolean isStatic();

	public abstract void setStatic(boolean isStatic);

	public abstract boolean isInverseable();

	public abstract void setInverseable(boolean isInverseable);

	public abstract MetaClass getType();

	public abstract void setType(MetaClass type);

	public abstract MetaClass getOwner();

	public abstract void setOwner(MetaClass owner);

	public abstract List<MetaAssociation> getAssociations();

	public abstract void setAssociations(List<MetaAssociation> associations);

	public abstract void setVersion(int version);

	public abstract int getVersion();

}
