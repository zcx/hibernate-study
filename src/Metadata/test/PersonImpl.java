package Metadata.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class PersonImpl implements Person{

	@Id
	@Column(name="ID")
	public int getId() {
		return 0;
	}

	@Override
	public void setId(int id) {
		
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void setName(String name) {
		
	}

	@Override
	public int getAge() {
		return 0;
	}

	@Override
	public void setAge(int age) {

	}

}
