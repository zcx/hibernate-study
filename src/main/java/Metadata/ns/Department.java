package Metadata.ns;

import java.util.HashMap;

public interface Department extends Namespace {
	@Override
	public String getId();

	@Override
	public Department getParent();

	@Override
	public String getName();

	public String getCaption();

	public void setProp(String propname, Object value);

	public Object getProp(String propname);

	public Object getPropIgnoreCase(String propname, Object def);

	public HashMap getPropsMap();

	public String toString();

	public boolean isLeafDepartment();
}
