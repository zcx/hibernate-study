package Metadata.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Software {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String id;

	@OneToMany(mappedBy = "software")
	@MapKey(name = "code")
	private Map<String, Version> versions = new HashMap<String, Version>();

	public void setVersions(Map<String, Version> versions) {
		this.versions = versions;
	}

	public Map<String, Version> getVersions() {
		return versions;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}