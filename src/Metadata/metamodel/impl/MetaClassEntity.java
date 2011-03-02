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

import Metadata.metamodel.MetaAttribute;
import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaObject;
import Metadata.metamodel.MetaPackage;

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
	private List<MetaAttribute> attributes = new ArrayList<MetaAttribute>();

	@OneToMany
	private List<MetaObject> instances = new ArrayList<MetaObject>();

	@ManyToOne
	private MetaClass superclass = null;

	@ManyToOne
	private MetaPackage namespace = null;

	@OneToMany
	private List<MetaClass> subclasses = new ArrayList<MetaClass>();

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
	public void setAttributes(List<MetaAttribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public List<MetaAttribute> getAttributes() {
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
	public void setInstances(List<MetaObject> instances) {
		this.instances = instances;
	}

	@Override
	public List<MetaObject> getInstances() {
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
	public void setNamespace(MetaPackage namespace) {
		this.namespace = namespace;
	}

	@Override
	public MetaPackage getNamespace() {
		return namespace;
	}

	@Override
	public void setSubclasses(List<MetaClass> subclasses) {
		this.subclasses = subclasses;
	}

	@Override
	public List<MetaClass> getSubclasses() {
		return subclasses;
	}
}
