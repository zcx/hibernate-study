package Metadata.test.composekey;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_CK_CHILD")
public class Child implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "parentCivility", referencedColumnName = "isMale"),
			@JoinColumn(name = "parentLastName", referencedColumnName = "lastName"),
			@JoinColumn(name = "parentFirstName", referencedColumnName = "firstName") })
	private Parent parent; //unidirectional

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Parent getParent() {
		return parent;
	}
}
