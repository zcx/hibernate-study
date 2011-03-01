package Metadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "HBPACKAGE")
public class HBPackage {
	@Id
	@Column(name = "ID")
	private String id;

	@Version
	@Column(name = "VERSION")
	private int version;

	@Column(name = "NAME")
	private String name;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}