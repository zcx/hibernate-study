package Metadata.test;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class WomanImpl extends PersonImpl implements Woman{

	@OneToOne
	@JoinColumn(name="HASBANDID")
	public Man getHasband() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHasband(Man hasband) {
		// TODO Auto-generated method stub
		
	}

}
