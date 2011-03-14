package Metadata.test;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Marriaged extends Person {
	
	@Column(name="MARRIAGEID")
	private String marriageid;

	public void setMarriageid(String marriageid) {
		this.marriageid = marriageid;
	}

	public String getMarriageid() {
		return marriageid;
	}
}
