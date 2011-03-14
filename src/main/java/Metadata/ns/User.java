package Metadata.ns;

import java.util.HashMap;

public interface User extends NamedElement{
	@Override
	public String getId();
	
	@Override
	public Department getNamespace();
	
	@Override
	public String getName();

	public boolean getEnabled();

	public void setEnabled(boolean isEnable);

	public String getPassword();

	public void setPassword(String password);

	public void setProp(String propname, Object value);

	public Object getProp(String propname);

	public HashMap getPropsMap();

	public String toString();
}
