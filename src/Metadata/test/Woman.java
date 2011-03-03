package Metadata.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public interface Woman extends Person{
	
	@Id
	@Column(name="ID")
	public void setId(int id);
	@Override
	public int getId();
	
	@OneToOne
	@JoinColumn(name="HASBANDID")
	public Man getHasband();
	public void setHasband(Man hasband);
}
