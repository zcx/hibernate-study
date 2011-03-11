package Metadata.metamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "MDR_META_LINK")
public class MetaLink{

	@Id
//	@Column(name = "ID", length = 32)
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private MetaLinkPK id;
	
	@ManyToOne
	@JoinColumn(name = "slot1id")
	private MetaSlot slot1;
	
	@ManyToOne
	@JoinColumn(name = "slot2id")
	private MetaSlot slot2;
	
	@Version
	@Column(name="VERSION")
	public int version;
	
	@ManyToOne
	@JoinColumn(name="ASSOCIATIONID")
	private MetaAssociation type = null;
	

	public MetaSlot getSlot1(){
		return this.slot1;
	}
	

	public void setSlot1(MetaSlot slot){
		this.slot1 = slot;
	}
	

	public MetaSlot getSlot2(){
		return this.slot2;
	}
	

	public void setSlot2(MetaSlot slot){
		this.slot2 = slot;
	}


	public void setId(MetaLinkPK id) {
		this.id = id;
	}
	

	public MetaLinkPK getId() {
		return id;
	}


	public void setType(MetaAssociation type) {
		this.type = type;
	}


	public MetaAssociation getType() {
		return type;
	}
}
