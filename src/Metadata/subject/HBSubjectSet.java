package Metadata.subject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HBSubjectSet")
public class HBSubjectSet {
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id = null;
	
	@Id
	@Column(name="VERSION")
	private int version;
	
	@OneToMany
	private Set<HBSubject> subjects = new HashSet<HBSubject>();
	
	@ManyToOne
	@JoinColumn(name="DOMAINID")
	private HBSubjectDomain owner = null;

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

	public void setSubjects(Set<HBSubject> subjects) {
		this.subjects = subjects;
	}

	public Set<HBSubject> getSubjects() {
		return subjects;
	}

	public void setOwner(HBSubjectDomain owner) {
		this.owner = owner;
	}

	public HBSubjectDomain getOwner() {
		return owner;
	}
	
}
