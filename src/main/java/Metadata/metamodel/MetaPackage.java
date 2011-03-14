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

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.subject.SubjectDomain;
import Metadata.util.HibernateUtil;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "MDR_META_PACKAGE")
public class MetaPackage {

	@Id
	@Column(name = "URI")
	private String uri;

	@Version
	@Column(name = "VERSION")
	private int version;

	@OneToMany(mappedBy = "namespace")
	public Set<MetaClass> classes = new HashSet<MetaClass>();

	@ManyToOne
	@JoinColumn(name = "SUPERPACKAGEID")
	private MetaPackage superpackage = null;

	@OneToMany(mappedBy = "superpackage")
	private Set<MetaPackage> subpackages = new HashSet<MetaPackage>();

	public void loadAnnotatedClass(Configuration conf) {
		conf.addAnnotatedClass(MetaLink.class);
		conf.addAnnotatedClass(MetaObject.class);
		conf.addAnnotatedClass(MetaSlot.class);
		conf.addAnnotatedClass(MetaClass.class);
		conf.addAnnotatedClass(MetaAttribute.class);
		conf.addAnnotatedClass(MetaPackage.class);
		conf.addAnnotatedClass(MetaAssociation.class);
	}

	public MetaClass getClass(Class<?> cls) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Object obj = session.get(MetaClass.class, cls.getName());
			if (obj == null) {
				return null;
			}
			return MetaClass.class.cast(obj);
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}
		finally {
			session.close();
		}

	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
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

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}

	protected MetaClass getMetaClassByJavaClass(Class<?> javacls, String name) throws Exception {
		MetaClass cls = this.getClass(javacls);
		if (cls != null) {
			return cls;
		}
		cls = new MetaClass();
		cls.setName(name);
		cls.setUri(SubjectDomain.class.getName());
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(cls);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		finally {
			session.close();
		}
		return cls;
	}
	
	public MetaFactory<?> getFactory(){
		return new MetaFactory<MetaPackage>(this);
	}
}
