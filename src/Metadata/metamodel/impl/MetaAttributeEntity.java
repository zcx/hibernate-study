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

import Metadata.metamodel.MetaAssociation;
import Metadata.metamodel.MetaAttribute;
import Metadata.metamodel.MetaClass;

@Entity
@Table(name = "HBATTRIBUTE")
public class MetaAttributeEntity implements MetaAttribute {

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
	private MetaClass type = null;

	@ManyToOne
	private MetaClass owner = null;

	@OneToMany
	private List<MetaAssociation> associations = new ArrayList<MetaAssociation>();

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#isNullable()
	 */
	@Override
	public boolean isNullable() {
		return isNullable;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setNullable(boolean)
	 */
	@Override
	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#isStatic()
	 */
	@Override
	public boolean isStatic() {
		return isStatic;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setStatic(boolean)
	 */
	@Override
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#isInverseable()
	 */
	@Override
	public boolean isInverseable() {
		return isInverseable;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setInverseable(boolean)
	 */
	@Override
	public void setInverseable(boolean isInverseable) {
		this.isInverseable = isInverseable;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#getType()
	 */
	@Override
	public MetaClass getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setType(Metadata.metamodel.impl.MetaClassEntity)
	 */
	@Override
	public void setType(MetaClass type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#getOwner()
	 */
	@Override
	public MetaClass getOwner() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setOwner(Metadata.metamodel.impl.MetaClassEntity)
	 */
	@Override
	public void setOwner(MetaClass owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#getAssociations()
	 */
	@Override
	public List<MetaAssociation> getAssociations() {
		return associations;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setAssociations(java.util.List)
	 */
	@Override
	public void setAssociations(List<MetaAssociation> associations) {
		this.associations = associations;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#setVersion(int)
	 */
	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see Metadata.metamodel.impl.test#getVersion()
	 */
	@Override
	public int getVersion() {
		return version;
	}

}
