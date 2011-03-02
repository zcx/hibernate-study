package Metadata.metamodel;

import java.util.List;

public interface MetaSlot {

	public String getID();

	public void setID(String id);

	public void setVersion(int version);

	public int getVersion();

	public void setLinks(List<MetaLink> links);

	public List<MetaLink> getLinks();

	public void setObject(MetaObject object);

	public MetaObject getObject();
}
