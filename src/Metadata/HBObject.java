package Metadata;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 这个类中将会涉及到hibernate对列表的引用
 * @author classfoo
 *
 */
@Entity
@Table(name = "DB_HBOBJECT")
public class HBObject {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator="idGenerator")
	@GenericGenerator(name="idGenerator", strategy="uuid")
	private String id;

	@OneToMany
	@JoinColumn(name = "SLOTS")
	private List<HBSlot> slots = null;

	public List<HBSlot> getSlots() {
		return this.slots;
	}
	
	public void setSlots(List<HBSlot> slots){
		this.slots = slots;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
