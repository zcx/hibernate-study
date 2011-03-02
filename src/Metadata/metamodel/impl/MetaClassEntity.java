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

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setVersion(int)
	 */
	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getVersion()
	 */
	@Override
	public int getVersion() {
		return version;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setAttributes(java.util.List)
	 */
	@Override
	public void setAttributes(List<MetaAttributeEntity> attributes) {
		this.attributes = attributes;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getAttributes()
	 */
	@Override
	public List<MetaAttributeEntity> getAttributes() {
		return attributes;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setInstances(java.util.List)
	 */
	@Override
	public void setInstances(List<MetaObjectEntity> instances) {
		this.instances = instances;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getInstances()
	 */
	@Override
	public List<MetaObjectEntity> getInstances() {
		return instances;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setSuperclass(Metadata.metamodel.impl.MetaClass)
	 */
	@Override
	public void setSuperclass(MetaClass superclass) {
		this.superclass = superclass;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getSuperclass()
	 */
	@Override
	public MetaClass getSuperclass() {
		return superclass;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setNamespace(Metadata.metamodel.impl.MetaPackageEntity)
	 */
	@Override
	public void setNamespace(MetaPackageEntity namespace) {
		this.namespace = namespace;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getNamespace()
	 */
	@Override
	public MetaPackageEntity getNamespace() {
		return namespace;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#setSubclasses(java.util.List)
	 */
	@Override
	public void setSubclasses(List<MetaClassEntity> subclasses) {
		this.subclasses = subclasses;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.MetaClass#getSubclasses()
	 */
	@Override
	public List<MetaClassEntity> getSubclasses() {
		return subclasses;
	}
}
