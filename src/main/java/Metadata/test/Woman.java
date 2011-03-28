package Metadata.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Woman extends Marriaged{
	
	@Column(name="mapkey")
	private String mankey = null;
	
	@ManyToOne
	@JoinColumn(name="manid")
	private Man man = null;

	public void setMankey(String mankey) {
		this.mankey = mankey;
	}

	public String getMankey() {
		return mankey;
	}

	public void setMan(Man man) {
		this.man = man;
	}

	public Man getMan() {
		return man;
	}
}