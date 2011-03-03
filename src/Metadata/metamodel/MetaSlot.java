package Metadata.metamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

/**
 * 通过Hibernate构建的元数据Slot存储测试验证类
 * 20110228
 *   ISSUE0001 为HBSlot增加owner，这是一个多对一的关系，使得多个HBSlot能够关联到一
 *   个HBObject中，这个提交主要也是为了测试git中尽量频繁创建分支的概念
 *   
 * 20110228
 *   构造另外一个分支ISSUE0002，它是从ISSUE001拷贝的，测试从bug fix分支继续克隆后的
 *   合并情况
 * @author classfoo
 *
 */
@Entity
@Table(name = "MDR_META_SLOT")
public class MetaSlot {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Version
	@Column(name = "VERSION")
	private int version;

	@ManyToOne
	private MetaObject object = null;

	@OneToMany
	private List<MetaLink> links = new ArrayList<MetaLink>();

	public String getID() {
		return this.id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public void setLinks(List<MetaLink> links) {
		this.links = links;
	}

	public List<MetaLink> getLinks() {
		return links;
	}

	public void setObject(MetaObject object) {
		this.object = object;
	}

	public MetaObject getObject() {
		return object;
	}

}
