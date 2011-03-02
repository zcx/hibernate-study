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
@Table(name="HBCLASS")
public class MetaClassEntity {

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
	private List<MetaAttributeEntity> attributes = new ArrayList<MetaAttributeEntity>();

	@OneToMany
	private List<MetaObjectEntity> instances = new ArrayList<MetaObjectEntity>();

	@ManyToOne
	private MetaClassEntity superclass = null;

	@ManyToOne
	private MetaPackageEntity namespace = null;

	@OneToMany
	private List<MetaClassEntity> subclasses = new ArrayList<MetaClassEntity>();

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

	public void setAttributes(List<MetaAttributeEntity> attributes) {
		this.attributes = attributes;
	}

	public List<MetaAttributeEntity> getAttributes() {
		return attributes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setInstances(List<MetaObjectEntity> instances) {
		this.instances = instances;
	}

	public List<MetaObjectEntity> getInstances() {
		return instances;
	}

	public void setSuperclass(MetaClassEntity superclass) {
		this.superclass = superclass;
	}

	public MetaClassEntity getSuperclass() {
		return superclass;
	}

	public void setNamespace(MetaPackageEntity namespace) {
		this.namespace = namespace;
	}

	public MetaPackageEntity getNamespace() {
		return namespace;
	}

	public void setSubclasses(List<MetaClassEntity> subclasses) {
		this.subclasses = subclasses;
	}

	public List<MetaClassEntity> getSubclasses() {
		return subclasses;
	}
}
