package Metadata.metamodel.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "HBPACKAGE")
public class MetaPackageEntity {

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
	
	public Set<MetaClassEntity> classes = new HashSet<MetaClassEntity>();

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
	
	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(MetaLinkEntity.class);
		conf.addAnnotatedClass(MetaObjectEntity.class);
		conf.addAnnotatedClass(MetaSlotEntity.class);
		conf.addAnnotatedClass(MetaClassEntity.class);
		conf.addAnnotatedClass(MetaAttributeEntity.class);
		conf.addAnnotatedClass(MetaPackageEntity.class);
		conf.addAnnotatedClass(MetaAssociationEntity.class);
		return conf.buildSessionFactory();
	}
	
}
