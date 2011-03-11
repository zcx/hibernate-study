package Metadata.metamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MDR_META_ATTRIBUTE")
public class MetaAttribute {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private int id;

	@Version
	@Column(name = "VERSION")
	private int version;

	@Column(name = "NAME")
	private String name = null;

	@Column(name = "ISNULLABLE")
	private boolean isNullable = false;

	@Column(name = "ISSTATIC")
	private boolean isStatic = false;

	@Column(name = "ISINVERSEABLE")
	private boolean isInverseable = false;

	@ManyToOne
	@JoinColumn(name="TYPEID")
	private MetaClass type = null;

	@ManyToOne
	@JoinColumn(name="OWNERID")
	private MetaClass owner = null;

	@OneToMany(mappedBy="end1")
	private List<MetaAssociation> linkby = new ArrayList<MetaAssociation>();
	
	@OneToMany(mappedBy="end2")
	private List<MetaAssociation> linkto = new ArrayList<MetaAssociation>();
	

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

	public MetaClass getType() {
		return type;
	}

	public void setType(MetaClass type) {
		this.type = type;
	}

	public MetaClass getOwner() {
		return owner;
	}

	public void setOwner(MetaClass owner) {
		this.owner = owner;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public void setLinkby(List<MetaAssociation> linkby) {
		this.linkby = linkby;
	}

	public List<MetaAssociation> getLinkby() {
		return linkby;
	}

	public void setLinkto(List<MetaAssociation> linkto) {
		this.linkto = linkto;
	}

	public List<MetaAssociation> getLinkto() {
		return linkto;
	}

}
