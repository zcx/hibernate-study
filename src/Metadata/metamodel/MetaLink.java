package Metadata.metamodel;

public interface MetaLink {

	public MetaSlot getSlot1();

	public void setSlot1(MetaSlot slot);

	public MetaSlot getSlot2();

	public void setSlot2(MetaSlot slot);

	public void setId(String id);

	public String getId();
}
