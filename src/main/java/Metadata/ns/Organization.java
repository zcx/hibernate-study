package Metadata.ns;

import java.util.Set;

public interface Organization extends Namespace{
	
	public void getSuper();
	
	public Set<Organization> getSubs();
	
	/**
	 * 获取负责人
	 * @return
	 */
	public String getGovernor();
	
	/**
	 * 获取电话号码
	 * @return
	 */
	public String getTel();
	
	/**
	 * 获取描述信息
	 * @return
	 */
	public String getDescription();

}
