package Metadata.test;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class ManImpl extends PersonImpl implements Man{

	@OneToOne
	@JoinColumn(name="WIFEID")
	public Woman getWife() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWife(Woman wife) {
		// TODO Auto-generated method stub
		
	}

}
