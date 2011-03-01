package Metadata;

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
@Table(name="HBCLASS")
public class HBClass {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id = null;

	@Version
	@Column(name = "VERSION")
	private int version;

	@Column(name = "NAME")
	private String name = null;

	@OneToMany
	private List<HBAttribute> attributes = new ArrayList<HBAttribute>();

	@OneToMany
	private List<HBObject> instances = new ArrayList<HBObject>();

	@ManyToOne
	@Column(name = "SUPERCLASSID")
	private HBClass superclass = null;

	@ManyToOne
	@Column(name = "NAMESPACEID")
	private HBPackage namespace = null;

	@OneToMany
	private List<HBClass> subclasses = new ArrayList<HBClass>();

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public void setAttributes(List<HBAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<HBAttribute> getAttributes() {
		return attributes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setInstances(List<HBObject> instances) {
		this.instances = instances;
	}

	public List<HBObject> getInstances() {
		return instances;
	}

	public void setSuperclass(HBClass superclass) {
		this.superclass = superclass;
	}

	public HBClass getSuperclass() {
		return superclass;
	}

	public void setNamespace(HBPackage namespace) {
		this.namespace = namespace;
	}

	public HBPackage getNamespace() {
		return namespace;
	}

	public void setSubclasses(List<HBClass> subclasses) {
		this.subclasses = subclasses;
	}

	public List<HBClass> getSubclasses() {
		return subclasses;
	}
}
