package Metadata;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import Metadata.metamodel.MetaAssociation;
import Metadata.metamodel.MetaAttribute;
import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaLink;
import Metadata.metamodel.MetaObject;
import Metadata.metamodel.MetaPackage;
import Metadata.metamodel.MetaSlot;
import Metadata.test.Person;
import Metadata.test.PersonImpl;

/**
 * 测试类
 * @author classfoo
 *
 */
public class Test {
	
	public static void main(String[] args) {
		Test test = new Test();
		test.doTest();
		//test.doTest1();
	}

	private void doTest1() {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Person person = new PersonImpl();
		session.save(person);
		session.getTransaction().commit();
		sf.close();
	}

	private void doTest() {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		MetaClass cls = new MetaClass();
		session.save(cls);
		//初始化object1，包含slot1，slot2
		MetaObject object1 = new MetaObject();
		MetaSlot slot1 = new MetaSlot();
		slot1.setObject(object1);
		session.save(slot1);
		object1.getSlots().add(slot1);
		MetaSlot slot2 = new MetaSlot();
		slot2.setObject(object1);
		object1.getSlots().add(slot2);
		session.save(object1);
		session.save(slot2);
		session.save(slot1);
		//初始化object2，包含slot3，slot4
		MetaObject object2 = new MetaObject();
		MetaSlot slot3 = new MetaSlot();
		slot3.setObject(object2);
		session.save(slot3);
		object2.getSlots().add(slot3);
		MetaSlot slot4 = new MetaSlot();
		slot4.setObject(object2);
		session.save(slot4);
		object2.getSlots().add(slot4);
		session.save(object2);
		//初始化link，连接slot1，slot3
		MetaLink link = new MetaLink();
		link.setSlot1(slot1);
		link.setSlot2(slot3);
		session.save(link);
		
		//
		List<?> result = session.createQuery("from MetaObject").list();
		Iterator<?> it = result.iterator();
		while (it.hasNext()) {
			MetaObject s = (MetaObject) it.next();
			System.out.println(s.getId());
		}
		session.getTransaction().commit();
		
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<?> slots = session.createQuery("from MetaSlot").list();
		it = slots.iterator();
		while(it.hasNext()){
			MetaSlot slot = (MetaSlot) it.next();
			MetaObject obj = slot.getObject();
			System.out.println(obj.getId());
		}
		session.getTransaction().commit();
		
		sf.close();
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
//		conf.addAnnotatedClass(Person.class);
//		conf.addAnnotatedClass(Man.class);
//		conf.addAnnotatedClass(Woman.class);
//		conf.addAnnotatedClass(PersonImpl.class);
//		conf.addAnnotatedClass(ManImpl.class);
//		conf.addAnnotatedClass(WomanImpl.class);
//		conf.addAnnotatedClass(Woman.class);
//		conf.addAnnotatedClass(Man.class);
		return conf.buildSessionFactory();
	}
}
