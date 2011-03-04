package Metadata.test.composekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParentPk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="FIRSTNAME", length=25)
	private String firstName;
	@Column(name="LASTNAME", length=25)
    private String lastName;
    private boolean isMale;
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
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

