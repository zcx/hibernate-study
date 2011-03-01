package Metadata;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

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
		HBClass cls = new HBClass();
		session.save(cls);
		//初始化object1，包含slot1，slot2
		HBObject object1 = new HBObject();
		HBSlot slot1 = new HBSlot();
		slot1.setObject(object1);
		session.save(slot1);
		object1.getSlots().add(slot1);
		HBSlot slot2 = new HBSlot();
		slot2.setObject(object1);
		object1.getSlots().add(slot2);
		session.save(object1);
		session.save(slot2);
		session.save(slot1);
		//初始化object2，包含slot3，slot4
		HBObject object2 = new HBObject();
		HBSlot slot3 = new HBSlot();
		slot3.setObject(object2);
		session.save(slot3);
		object2.getSlots().add(slot3);
		HBSlot slot4 = new HBSlot();
		slot4.setObject(object2);
		session.save(slot4);
		object2.getSlots().add(slot4);
		session.save(object2);
		//初始化link，连接slot1，slot3
		HBLink link = new HBLink();
		link.setSlot1(slot1);
		link.setSlot2(slot3);
		session.save(link);
		
		//
		List<?> result = session.createQuery("from HBObject").list();
		Iterator<?> it = result.iterator();
		while (it.hasNext()) {
			HBObject s = (HBObject) it.next();
			System.out.println(s.getId());
		}
		session.getTransaction().commit();
		
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<?> slots = session.createQuery("from HBSlot").list();
		it = slots.iterator();
		while(it.hasNext()){
			HBSlot slot = (HBSlot) it.next();
			HBObject obj = slot.getObject();
			System.out.println(obj.getId());
		}
		session.getTransaction().commit();
		
		sf.close();
	}

	private SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(HBLink.class);
		conf.addAnnotatedClass(HBObject.class);
		conf.addAnnotatedClass(HBSlot.class);
		return conf.buildSessionFactory();
	}
}
