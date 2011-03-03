package Metadata.metamodel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.cfg.Configuration;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "MDR_META_PACKAGE")
public class MetaPackage {

	@Id
//	@GeneratedValue(generator = "mpidGenerator")
//	@GenericGenerator(name = "mpidGenerator", strategy = "Metadata.metamodel.MetaPackageIDGenerator", parameters = { @Parameter(name = "sequence", value = "seq_payablemoney") })
	@Column(name="NAME")
	private String name;

	@Version
	@Column(name = "VERSION")
	private int version;

	@OneToMany
	public Set<MetaClass> classes = new HashSet<MetaClass>();

	@ManyToOne
	@JoinColumn(name = "SUPERPACKAGEID")
	private MetaPackage superpackage = null;

	@OneToMany
	private Set<MetaPackage> subpackages = new HashSet<MetaPackage>();
	
	public void loadAnnotatedClass(Configuration conf){
		conf.addAnnotatedClass(MetaLink.class);
		conf.addAnnotatedClass(MetaObject.class);
		conf.addAnnotatedClass(MetaSlot.class);
		conf.addAnnotatedClass(MetaClass.class);
		conf.addAnnotatedClass(MetaAttribute.class);
		conf.addAnnotatedClass(MetaPackage.class);
		conf.addAnnotatedClass(MetaAssociation.class);
	}

	public MetaClass getClass(int classid) {
		return null;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSuperpackage(MetaPackage superpackage) {
		this.superpackage = superpackage;
	}

	public MetaPackage getSuperpackage() {
		return superpackage;
	}

	public void setSubpackages(Set<MetaPackage> subpackages) {
		this.subpackages = subpackages;
	}

	public Set<MetaPackage> getSubpackages() {
		return subpackages;
	}

}
