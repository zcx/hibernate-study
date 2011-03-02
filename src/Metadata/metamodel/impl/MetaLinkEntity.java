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

import Metadata.metamodel.MetaLink;
import Metadata.metamodel.MetaSlot;

@Entity
@Table(name="HBLINK")
public class MetaLinkEntity implements MetaLink {

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
	private MetaSlot slot1;
	
	@OneToOne
	@JoinColumn(name = "SLOT2ID")
	private MetaSlot slot2;
	
	@Override
	public MetaSlot getSlot1(){
		return this.slot1;
	}
	
	@Override
	public void setSlot1(MetaSlot slot){
		this.slot1 = slot;
	}
	
	@Override
	public MetaSlot getSlot2(){
		return this.slot2;
	}
	
	@Override
	public void setSlot2(MetaSlot slot){
		this.slot2 = slot;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String getId() {
		return id;
	}
}
