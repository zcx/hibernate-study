package Metadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.mapping.List;

/**
 * 这个类中将会涉及到hibernate对列表的引用
 * @author classfoo
 *
 */
@Entity
@Table(name="DB_HBOBJECT")
public class HBObject {
	
	@Id
	@Column(name="ID")
	private int id;
	
	private List slots = null;
	
	public List getSlots() {
		return this.slots;
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}
}
