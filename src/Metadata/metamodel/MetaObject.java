package Metadata.metamodel;

import java.util.List;

public interface MetaObject {

	public List<MetaSlot> getSlots();

	public void setSlots(List<MetaSlot> slots);

	public String getId();

	public void setId(String id);

}