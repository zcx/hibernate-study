package Metadata.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "NSNAME")
public class NSName {
	@Id
	@Column(name = "nid", length = 32)
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String nid = null;

	@Column(name = "NAME")
	private String name = null;

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNid() {
		return nid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
