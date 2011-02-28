package Metadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

/**
 * 为fuzhq分支添加部分代码，制造其与ISSUE0001的冲突，进行测试
 * @author classfoo
 *
 */
/**
 * 通过Hibernate构建的元数据Slot存储测试验证类
 * 20110228
 *   ISSUE0001 为HBSlot增加owner，这是一个多对一的关系，使得多个HBSlot能够关联到一
 *   个HBObject中，这个提交主要也是为了测试git中尽量频繁创建分支的概念
 * @author classfoo
 *
 */
@Entity
@Table(name="DB_HBSLOT")
public class HBSlot {
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Version
	@Column(name="VERSION")
	private int version;
	
	@ManyToOne
	@JoinColumn(name="OBJECTID")
	private HBObject owner = null;
	
	public String getID(){
		return this.id;
	}
	
	public void setID(String id){
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public void setOwner(HBObject owner) {
		this.owner = owner;
	}

	public HBObject getOwner() {
		return owner;
	}
	
	
}
