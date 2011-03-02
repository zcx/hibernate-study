package Metadata.metamodel.impl;

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

import Metadata.metamodel.MetaLink;
import Metadata.metamodel.MetaObject;
import Metadata.metamodel.MetaSlot;

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
@Table(name = "HBSLOT")
public class MetaSlotEntity implements MetaSlot {

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
	
	private int test;

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#getID()
	 */
	@Override
	public String getID() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#setID(java.lang.String)
	 */
	@Override
	public void setID(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#setVersion(int)
	 */
	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#getVersion()
	 */
	@Override
	public int getVersion() {
		return version;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#setLinks(java.util.List)
	 */
	@Override
	public void setLinks(List<MetaLink> links) {
		this.links = links;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#getLinks()
	 */
	@Override
	public List<MetaLink> getLinks() {
		return links;
	}
	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#setObject(Metadata.metamodel.impl.MetaObjectEntity)
	 */
	@Override
	public void setObject(MetaObject object) {
		this.object = object;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaSlot#getObject()
	 */
	@Override
	public MetaObject getObject() {
		return object;
	}

}
