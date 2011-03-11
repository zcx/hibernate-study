package Metadata.ns.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

import Metadata.ns.MetaObject;

@Entity(name="MetaObject")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class HBRMetaObjectImpl implements MetaObject{
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String id = null;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
