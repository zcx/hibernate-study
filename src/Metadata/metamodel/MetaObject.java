package Metadata.metamodel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 这个类中将会涉及到hibernate对列表的引用
 * 所有的元数据类都应该是扩展了MetaObject，它们内部都应该有主键ID，且与MetaObject的
 * ID字段产生共享主键的关联关系
 * 数据库表结构如下：
 * 
 * 
 * @author classfoo
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MDR_META_OBJECT")
public class MetaObject {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String id;

	@Version
	@Column(name = "VERSION")
	private int version;

	@OneToMany(mappedBy="object")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<MetaSlot> slots = new ArrayList<MetaSlot>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLASSID")
	private MetaClass type = null;
	
	@Column(name="MODIFYTIME")
	private Timestamp modifytime = null;
	
	@Column(name="CREATETIME")
	private Timestamp createtime = null;
	
	protected MetaObject() {
	}

	public List<MetaSlot> getSlots() {
		return this.slots;
	}

	public void setSlots(List<MetaSlot> slots) {
		this.slots = slots;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public void setType(MetaClass type) {
		this.type = type;
	}

	public MetaClass getType() {
		return type;
	}

	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}

	/**
	 * 获取最后一次修改时间
	 * @return
	 */
	public Timestamp getModifytime() {
		return modifytime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	/**
	 * 获取创建时间
	 * @return
	 */
	public Timestamp getCreatetime() {
		return createtime;
	}
}
