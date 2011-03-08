package Metadata.test;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Woman extends Person{

	@OneToOne
	@JoinColumn(name="HASBANDID")
	public Man getHasband() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHasband(Man hasband) {
		
	}

}