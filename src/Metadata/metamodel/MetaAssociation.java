package Metadata.metamodel;

import java.util.List;

public interface MetaAssociation {

	public abstract void setEnd1(MetaAttribute end1);

	public abstract MetaAttribute getEnd1();

	public abstract void setEnd2(MetaAttribute end2);

	public abstract MetaAttribute getEnd2();

	public abstract void setLinks(List<MetaLink> links);

	public abstract List<MetaLink> getLinks();

	public abstract void setId(String id);

	public abstract String getId();

}
