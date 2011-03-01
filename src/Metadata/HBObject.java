package Metadata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 这个类中将会涉及到hibernate对列表的引用
 * @author classfoo
 *
 */
@Entity
@Table(name = "HBOBJECT")
public class HBObject {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator="idGenerator")
	@GenericGenerator(name="idGenerator", strategy="uuid")
	private String id;

	@OneToMany
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<HBSlot> slots = new ArrayList<HBSlot>();

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
