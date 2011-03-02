package Metadata.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HBATTRIBUTE")
public class MetaAttributeEntity {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int id;
	
	@Version
	@Column(name="VERSION")
	private int version;

	@Column(name="NAME")
	private String name = null;

	@Column(name="ISNULLABLE")
	private boolean isNullable = false;
	
	@Column(name="ISSTATIC")
	private boolean isStatic = false;

	@Column(name="ISINVERSEABLE")
	private boolean isInverseable = false;

	@ManyToOne
	private MetaClassEntity type = null;

	@ManyToOne
	private MetaClassEntity owner = null;

	@OneToMany
	private List<MetaAssociationEntity> associations = new ArrayList<MetaAssociationEntity>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNullable() {
		return isNullable;
	}

	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isInverseable() {
		return isInverseable;
	}

	public void setInverseable(boolean isInverseable) {
		this.isInverseable = isInverseable;
	}

	public MetaClassEntity getType() {
		return type;
	}

	public void setType(MetaClassEntity type) {
		this.type = type;
	}

	public MetaClassEntity getOwner() {
		return owner;
	}

	public void setOwner(MetaClassEntity owner) {
		this.owner = owner;
	}

	public List<MetaAssociationEntity> getAssociations() {
		return associations;
	}

	public void setAssociations(List<MetaAssociationEntity> associations) {
		this.associations = associations;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

}
