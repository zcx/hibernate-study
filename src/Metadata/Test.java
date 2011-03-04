package Metadata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.db.Catalog;
import Metadata.db.Schema;
import Metadata.db.Table;
import Metadata.metamodel.HibernateUtil;
import Metadata.metamodel.MetaAssociation;
import Metadata.metamodel.MetaAttribute;
import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaDataRepository;
import Metadata.metamodel.MetaLink;
import Metadata.metamodel.MetaObject;
import Metadata.metamodel.MetaPackage;
import Metadata.metamodel.MetaSlot;
import Metadata.subject.Subject;
import Metadata.subject.SubjectDomain;
import Metadata.subject.SubjectFactory;
import Metadata.subject.SubjectField;
import Metadata.subject.SubjectPackage;
import Metadata.subject.SubjectSet;

import com.mysql.jdbc.Field;

/**
 * 测试类
 * @author classfoo
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		Test test = new Test();
		//test.doTest();
		test.doTest1();
	}

	private void doTest1() throws Exception {
		MetaDataRepository mdr = new MetaDataRepository();
		SubjectPackage pkg = mdr.getPackage(SubjectPackage.class);
		SubjectFactory factory = pkg.getFactory();
		Subject subject = factory.createSubject();
		MetaClass type = subject.getType();
		System.out.println(type);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(subject);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}

	private void doTest() {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		try {
			Subject subject = new Subject();
			session.save(subject);
			MetaClass type = subject.getType();
			SubjectSet subjectset = new SubjectSet();
			subjectset.getSubjects().add(subject);
			session.save(subjectset);
			
			Catalog catalog = new Catalog();
			session.save(catalog);
			Schema schema = new Schema();
			session.save(schema);
			//			
			//			MetaClass cls = new MetaClass();
			//			session.save(cls);
			//			//初始化object1，包含slot1，slot2
			//			MetaObject object1 = new MetaObject();
			//			MetaSlot slot1 = new MetaSlot();
			//			slot1.setObject(object1);
			//			session.save(slot1);
			//			object1.getSlots().add(slot1);
			//			MetaSlot slot2 = new MetaSlot();
			//			slot2.setObject(object1);
			//			object1.getSlots().add(slot2);
			//			session.save(object1);
			//			session.save(slot2);
			//			session.save(slot1);
			//			//初始化object2，包含slot3，slot4
			//			MetaObject object2 = new MetaObject();
			//			MetaSlot slot3 = new MetaSlot();
			//			slot3.setObject(object2);
			//			session.save(slot3);
			//			object2.getSlots().add(slot3);
			//			MetaSlot slot4 = new MetaSlot();
			//			slot4.setObject(object2);
			//			session.save(slot4);
			//			object2.getSlots().add(slot4);
			//			session.save(object2);
			//			//初始化link，连接slot1，slot3
			//			MetaLink link = new MetaLink();
			//			link.setSlot1(slot1);
			//			link.setSlot2(slot3);
			//			session.save(link);
			//
			//			List<?> result = session.createQuery("from MetaObject").list();
			//			Iterator<?> it = result.iterator();
			//			while (it.hasNext()) {
			//				MetaObject s = (MetaObject) it.next();
			//				System.out.println(s.getId());
			//			}
			//			session.getTransaction().commit();
			//
			//			session = sf.getCurrentSession();
			//			session.beginTransaction();
			//			List<?> slots = session.createQuery("from MetaSlot").list();
			//			it = slots.iterator();
			//			while (it.hasNext()) {
			//				MetaSlot slot = (MetaSlot) it.next();
			//				MetaObject obj = slot.getObject();
			//				System.out.println(obj.getId());
			//			}
			session.getTransaction().commit();
		}
		catch (Exception e) {
			session.getTransaction().rollback();
		}
		finally {
			sf.close();
		}
	}

	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(MetaLink.class);
		conf.addAnnotatedClass(MetaObject.class);
		conf.addAnnotatedClass(MetaSlot.class);
		conf.addAnnotatedClass(MetaClass.class);
		conf.addAnnotatedClass(MetaAttribute.class);
		conf.addAnnotatedClass(MetaPackage.class);
		conf.addAnnotatedClass(MetaAssociation.class);

		conf.addAnnotatedClass(MetaObject.class);
		conf.addAnnotatedClass(MetaClass.class);
		conf.addAnnotatedClass(MetaAttribute.class);
		conf.addAnnotatedClass(MetaLink.class);
		conf.addAnnotatedClass(MetaAssociation.class);
		conf.addAnnotatedClass(MetaSlot.class);

		conf.addAnnotatedClass(Subject.class);
		conf.addAnnotatedClass(SubjectSet.class);
		conf.addAnnotatedClass(SubjectDomain.class);
		conf.addAnnotatedClass(SubjectField.class);

		conf.addAnnotatedClass(Catalog.class);
		conf.addAnnotatedClass(Schema.class);
		conf.addAnnotatedClass(Table.class);
		conf.addAnnotatedClass(Field.class);

		return conf.buildSessionFactory();
	}
}
