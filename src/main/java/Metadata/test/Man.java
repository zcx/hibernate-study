package Metadata.test;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Man extends Person{

	@OneToOne
	@JoinColumn(name="WIFEID")
	public Woman getWife() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setWife(Woman wife) {
		
	}

}