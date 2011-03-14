package zcx.mapping;

/**
 * 此类会通过hbm.xml配置文件映射到数据库表
 * @author zhuchx
 */
public class CustomMapping {
	private long id;

	private String title;

	public CustomMapping() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
