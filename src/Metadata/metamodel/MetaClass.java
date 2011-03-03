package Metadata.metamodel;

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
@Table(name = "MDR_META_CLASS")
public class MetaClass {
	
	protected MetaClass() {
		// TODO Auto-generated constructor stub
	}

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
	private List<MetaAttribute> attributes = new ArrayList<MetaAttribute>();

	@OneToMany
	private List<MetaObject> instances = new ArrayList<MetaObject>();

	@ManyToOne
	private MetaClass superclass = null;

	@ManyToOne
	private MetaPackage namespace = null;

	@OneToMany
	private List<MetaClass> subclasses = new ArrayList<MetaClass>();

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

	public void setAttributes(List<MetaAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<MetaAttribute> getAttributes() {
		return attributes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setInstances(List<MetaObject> instances) {
		this.instances = instances;
	}

	public List<MetaObject> getInstances() {
		return instances;
	}

	public void setSuperclass(MetaClass superclass) {
		this.superclass = superclass;
	}

	public MetaClass getSuperclass() {
		return superclass;
	}

	public void setNamespace(MetaPackage namespace) {
		this.namespace = namespace;
	}

	public MetaPackage getNamespace() {
		return namespace;
	}

	public void setSubclasses(List<MetaClass> subclasses) {
		this.subclasses = subclasses;
	}

	public List<MetaClass> getSubclasses() {
		return subclasses;
	}
}
