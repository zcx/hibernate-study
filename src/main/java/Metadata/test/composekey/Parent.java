package Metadata.test.composekey;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_CK_PARENT")
@IdClass(ParentPk.class)
public class Parent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String firstName;
	
	@Id
	private String lastName;

	@Id
	private boolean isMale;

	private int age;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "parentCivility", referencedColumnName = "isMale"),
			@JoinColumn(name = "parentLastName", referencedColumnName = "lastName"),
			@JoinColumn(name = "parentFirstName", referencedColumnName = "firstName") })
	private Set<Child> children; //unidirectional

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public boolean isMale() {
		return isMale;
	}
}
