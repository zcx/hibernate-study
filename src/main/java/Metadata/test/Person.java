package Metadata.test;

import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.GenericGenerator;

import Metadata.util.HibernateUtil;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="PERSON")
public abstract class Person{

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "idGenerator")
	//@GenericGenerator(name = "idGenerator", strategy = "increment")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String id;
	
	public String getId() {
		return this.id;
	}
	


	public void setId(String id) {
		this.id = id;
	}
	
	public void excuteHQL(String hql){
		Session session2 = HibernateUtil.getSession();
		Query query = session2.createQuery(hql);
		Iterator it = query.iterate();
		while(it.hasNext()){
			Object next = it.next();
			System.out.println(next);
		}
	}
}
