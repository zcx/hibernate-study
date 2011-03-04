package Metadata.subject;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.metamodel.HibernateUtil;
import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaPackage;

@Entity
public class SubjectPackage extends MetaPackage {

	public void loadAnnotatedClass(Configuration conf) {
		conf.addAnnotatedClass(Subject.class);
		conf.addAnnotatedClass(SubjectSet.class);
		conf.addAnnotatedClass(SubjectDomain.class);
		conf.addAnnotatedClass(SubjectField.class);
		conf.addAnnotatedClass(SubjectPackage.class);
	}

	public MetaClass getSubjectDomain() throws Exception {
		return getMetaClassByJavaClass(SubjectDomain.class, "SubjectDomain");
	}

	private MetaClass getMetaClassByJavaClass(Class<?> javacls, String name) throws Exception {
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

	public MetaClass getSubjectField() throws Exception {
		return getMetaClassByJavaClass(SubjectField.class, "SubjectField");
	}

	public MetaClass getSubjectSet() throws Exception {
		return getMetaClassByJavaClass(SubjectSet.class, "SubjectSet");
	}

	public MetaClass getSubject() throws Exception {
		return getMetaClassByJavaClass(Subject.class, "Subject");
	}

	public SubjectFactory getFactory() {
		return new SubjectFactory(this);
	}
}