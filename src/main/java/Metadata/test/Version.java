package Metadata.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_version")
public class Version {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String id;

	@Column(name="code")
	private String code;

	@ManyToOne
	@JoinColumn(name="softwareid")
	private Software software;

	public void setSoftware(Software software) {
		this.software = software;
	}

	public Software getSoftware() {
		return software;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}