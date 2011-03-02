package Metadata.metamodel;


public interface MetaLink {

	public abstract MetaSlot getSlot1();

	public abstract void setSlot1(MetaSlot slot);

	public abstract MetaSlot getSlot2();

	public abstract void setSlot2(MetaSlot slot);

	public abstract void setId(String id);

	public abstract String getId();
}
