package Metadata;

import javax.persistence.Entity;
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
	
	private List slots = null;
	
	public List getSlots() {
		return this.slots;
	}
}
