package Metadata.metamodel;

import java.util.List;

public interface MetaObject {

	public String getId();

	public void setId(String id);
	
	public int getVersion();
	
	public void setVersion(int version);

	public List<MetaSlot> getSlots();

	public void setSlots(List<MetaSlot> slots);


}