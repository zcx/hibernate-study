package Metadata.test.composekey;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEST_CK_PARENT")
public class Parent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private ParentPk id;
    private int age;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumns ({
        @JoinColumn(name="parentCivility", referencedColumnName = "isMale"),
        @JoinColumn(name="parentLastName", referencedColumnName = "lastName"),
        @JoinColumn(name="parentFirstName", referencedColumnName = "firstName")
    })
	private Set<Child> children; //unidirectional

	public void setId(ParentPk id) {
		this.id = id;
	}

	public ParentPk getId() {
		return id;
	}

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
}

