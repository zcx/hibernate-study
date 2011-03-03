package Metadata.metamodel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "MDR_META_PACKAGE")
public class MetaPackage {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Version
	@Column(name = "VERSION")
	private int version;

	@Column(name = "NAME")
	private String name;

	@OneToMany
	public Set<MetaClass> classes = new HashSet<MetaClass>();

	public MetaPackage(Configuration configure) {
		this.loadAnnotationClasses(configure);
	}

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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void loadAnnotationClasses(Configuration conf) {
		conf.addAnnotatedClass(MetaLink.class);
		conf.addAnnotatedClass(MetaObject.class);
		conf.addAnnotatedClass(MetaSlot.class);
		conf.addAnnotatedClass(MetaClass.class);
		conf.addAnnotatedClass(MetaAttribute.class);
		conf.addAnnotatedClass(MetaPackage.class);
		conf.addAnnotatedClass(MetaAssociation.class);
	}

}
