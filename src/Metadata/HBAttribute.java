package Metadata;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "HBATTRIBUTE")
public class HBAttribute {

	@Id
	@Column(name="ID")
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
	@Column(name="TYPE")
	private HBClass type = null;

	@ManyToOne
	private HBClass owner = null;

	@OneToMany
	private List<HBAssociation> associations = new ArrayList<HBAssociation>();

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

	public HBClass getType() {
		return type;
	}

	public void setType(HBClass type) {
		this.type = type;
	}

	public HBClass getOwner() {
		return owner;
	}

	public void setOwner(HBClass owner) {
		this.owner = owner;
	}

	public List<HBAssociation> getAssociations() {
		return associations;
	}

	public void setAssociations(List<HBAssociation> associations) {
		this.associations = associations;
	}

}
