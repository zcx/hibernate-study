package Metadata;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import Metadata.metamodel.MetaClass;
import Metadata.metamodel.MetaLink;
import Metadata.metamodel.MetaObject;
import Metadata.metamodel.MetaSlot;
import Metadata.metamodel.impl.MetaAssociationEntity;
import Metadata.metamodel.impl.MetaAttributeEntity;
import Metadata.metamodel.impl.MetaClassEntity;
import Metadata.metamodel.impl.MetaLinkEntity;
import Metadata.metamodel.impl.MetaObjectEntity;
import Metadata.metamodel.impl.MetaPackageEntity;
import Metadata.metamodel.impl.MetaSlotEntity;

/**
 * 测试类
 * @author classfoo
 *
 */
public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.doTest();
	}

	private void doTest() {
		SessionFactory sf = getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		MetaClass cls = new MetaClassEntity();
		session.save(cls);
		//初始化object1，包含slot1，slot2
		MetaObject object1 = new MetaObjectEntity();
		MetaSlotEntity slot1 = new MetaSlotEntity();
		slot1.setObject(object1);
		session.save(slot1);
		object1.getSlots().add(slot1);
		MetaSlotEntity slot2 = new MetaSlotEntity();
		slot2.setObject(object1);
		object1.getSlots().add(slot2);
		session.save(object1);
		session.save(slot2);
		session.save(slot1);
		//初始化object2，包含slot3，slot4
		MetaObject object2 = new MetaObjectEntity();
		MetaSlotEntity slot3 = new MetaSlotEntity();
		slot3.setObject(object2);
		session.save(slot3);
		object2.getSlots().add(slot3);
		MetaSlotEntity slot4 = new MetaSlotEntity();
		slot4.setObject(object2);
		session.save(slot4);
		object2.getSlots().add(slot4);
		session.save(object2);
		//初始化link，连接slot1，slot3
		MetaLink link = new MetaLinkEntity();
		link.setSlot1(slot1);
		link.setSlot2(slot3);
		session.save(link);
		
		//
		List<?> result = session.createQuery("from HBObject").list();
		Iterator<?> it = result.iterator();
		while (it.hasNext()) {
			MetaObject s = (MetaObject) it.next();
			System.out.println(s.getId());
		}
		session.getTransaction().commit();
		
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<?> slots = session.createQuery("from HBSlot").list();
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
