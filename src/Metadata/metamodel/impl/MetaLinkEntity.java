package Metadata.metamodel.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HBLINK")
public class MetaLinkEntity {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Version
	@Column(name="VERSION")
	public int version;
	
	@OneToOne
	@JoinColumn(name = "SLOT1ID")
	private MetaSlotEntity slot1;
	
	@OneToOne
	@JoinColumn(name = "SLOT2ID")
	private MetaSlotEntity slot2;
	
	public MetaSlotEntity getSlot1(){
		return this.slot1;
	}
	
	public void setSlot1(MetaSlotEntity slot){
		this.slot1 = slot;
	}
	
	public MetaSlotEntity getSlot2(){
		return this.slot2;
	}
	
	public void setSlot2(MetaSlotEntity slot){
		this.slot2 = slot;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
