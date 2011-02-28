package Metadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="DB_HBLINK")
public class HBLink {
	@Id
	@Column(name="version")
	public int id;
	
	@Version
	@Column(name="VERSION")
	public int version;
	
	@Column(name="SLOT1")
	private HBSlot slot1;
	
	@Column(name="SLOT2")
	private HBSlot slot2;
	
	@ManyToOne
	public HBSlot getSlot1(){
		return this.slot1;
	}
	
	@ManyToOne
	public HBSlot getSlot2(){
		return this.slot2;
	}
	
}
