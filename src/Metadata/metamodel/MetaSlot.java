package Metadata.metamodel;

import java.util.List;

public interface MetaSlot {

	public abstract String getID();

	public abstract void setID(String id);

	public abstract void setVersion(int version);

	public abstract int getVersion();

	public abstract void setLinks(List<MetaLink> links);

	public abstract List<MetaLink> getLinks();

	public abstract void setObject(MetaObject object);

	public abstract MetaObject getObject();
}
