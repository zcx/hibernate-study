package Metadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DB_METASLOT")
public class HBSlot {
	
	@Id
	@Column(name="ID")
	private int id;
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
}
