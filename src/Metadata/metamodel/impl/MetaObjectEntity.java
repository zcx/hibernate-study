package Metadata.metamodel.impl;

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

import Metadata.metamodel.MetaObject;
import Metadata.metamodel.MetaSlot;

/**
 * 这个类中将会涉及到hibernate对列表的引用
 * @author classfoo
 *
 */
@Entity
@Table(name = "HBOBJECT")
public class MetaObjectEntity implements MetaObject {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator="idGenerator")
	@GenericGenerator(name="idGenerator", strategy="uuid")
	private String id;

	@OneToMany
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<MetaSlot> slots = new ArrayList<MetaSlot>();

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaObject#getSlots()
	 */
	@Override
	public List<MetaSlot> getSlots() {
		return this.slots;
	}
	
	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaObject#setSlots(java.util.List)
	 */
	@Override
	public void setSlots(List<MetaSlot> slots){
		this.slots = slots;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaObject#getId()
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaObject#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}
}
