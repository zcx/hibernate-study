package Metadata;

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
@Table(name="DB_HBLINK")
public class HBLink {

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
	private HBSlot slot1;
	
	@OneToOne
	@JoinColumn(name = "SLOT2ID")
	private HBSlot slot2;
	
	public HBSlot getSlot1(){
		return this.slot1;
	}
	
	public void setSlot1(HBSlot slot){
		this.slot1 = slot;
	}
	
	public HBSlot getSlot2(){
		return this.slot2;
	}
	
	public void setSlot2(HBSlot slot){
		this.slot2 = slot;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
