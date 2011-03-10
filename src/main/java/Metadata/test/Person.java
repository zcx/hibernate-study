package Metadata.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person{

	@Id
	@Column(name="ID")
	public int getId() {
		return 0;
	}


	public void setId(int id) {
		
	}


	public String getName() {
		return null;
	}


	public void setName(String name) {
		
	}


	public int getAge() {
		return 0;
	}


	public void setAge(int age) {

	}

}
