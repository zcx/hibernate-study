package Metadata.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PERSON")
public interface Person{
	@Id
	@Column(name="ID")
	public int getId();
	public void setId(int id);
	public String getName();
	public void setName(String name);
	public int getAge();
	public void setAge(int age);
}
