package Metadata.test.composekey;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Metadata.metamodel.HibernateUtil;

/**
 * 测试创建聚合主键：
 * @author classfoo
 *
 */
public class ComposeKeyTest {
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		conf.configure("/Metadata/metadata-hibernate.cfg.xml");
		conf.addAnnotatedClass(Child.class);
		conf.addAnnotatedClass(Parent.class);
		conf.addAnnotatedClass(ParentPk.class);
		HibernateUtil.setConfiguration(conf);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try{
			Parent parent = new Parent();
			ParentPk pk = new ParentPk();
			pk.setFirstName("Class");
			pk.setLastName("Foo");
			pk.setMale(true);
			parent.setId(pk);
			session.saveOrUpdate(parent);
			Child child = new Child();
			session.saveOrUpdate(child);
			//parent.getChildren().add(child);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
}
