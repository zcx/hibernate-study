package Metadata.metamodel;

import java.util.List;

public interface MetaAssociation {

	public void setEnd1(MetaAttribute end1);

	public MetaAttribute getEnd1();

	public void setEnd2(MetaAttribute end2);

	public MetaAttribute getEnd2();

	public void setLinks(List<MetaLink> links);

	public List<MetaLink> getLinks();

	public void setId(String id);

	public String getId();

}
