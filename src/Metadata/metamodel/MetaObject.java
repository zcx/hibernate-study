package Metadata.metamodel;

import java.util.List;

public interface MetaObject {

	public abstract List<MetaSlot> getSlots();

	public abstract void setSlots(List<MetaSlot> slots);

	public abstract String getId();

	public abstract void setId(String id);

}