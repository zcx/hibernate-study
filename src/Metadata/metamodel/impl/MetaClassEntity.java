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

import Metadata.metamodel.MetaClass;

@Entity
@Table(name="HBCLASS")
public class MetaClassEntity implements MetaClass {

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
	private MetaClass superclass = null;

	@ManyToOne
	private MetaPackageEntity namespace = null;

	@OneToMany
	private List<MetaClassEntity> subclasses = new ArrayList<MetaClassEntity>();

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int getVersion() {
		return version;
	}

	@Override
	public void setAttributes(List<MetaAttributeEntity> attributes) {
		this.attributes = attributes;
	}

	@Override
	public List<MetaAttributeEntity> getAttributes() {
		return attributes;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setInstances(List<MetaObjectEntity> instances) {
		this.instances = instances;
	}

	@Override
	public List<MetaObjectEntity> getInstances() {
		return instances;
	}

	@Override
	public void setSuperclass(MetaClass superclass) {
		this.superclass = superclass;
	}

	@Override
	public MetaClass getSuperclass() {
		return superclass;
	}

	@Override
	public void setNamespace(MetaPackageEntity namespace) {
		this.namespace = namespace;
	}

	@Override
	public MetaPackageEntity getNamespace() {
		return namespace;
	}

	@Override
	public void setSubclasses(List<MetaClassEntity> subclasses) {
		this.subclasses = subclasses;
	}

	@Override
	public List<MetaClassEntity> getSubclasses() {
		return subclasses;
	}
}
