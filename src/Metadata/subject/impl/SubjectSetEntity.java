package Metadata.subject.impl;

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

import Metadata.subject.Subject;
import Metadata.subject.SubjectDomain;
import Metadata.subject.SubjectSet;

@Entity
@Table(name="HBSubjectSet")
public class SubjectSetEntity implements SubjectSet {
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id = null;
	
	@Id
	@Column(name="VERSION")
	private int version;
	
	@OneToMany
	private Set<Subject> subjects = new HashSet<Subject>();
	
	@ManyToOne
	@JoinColumn(name="DOMAINID")
	private SubjectDomain owner = null;

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#setVersion(int)
	 */
	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#getVersion()
	 */
	@Override
	public int getVersion() {
		return version;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#setSubjects(java.util.Set)
	 */
	@Override
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#getSubjects()
	 */
	@Override
	public Set<Subject> getSubjects() {
		return subjects;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#setOwner(Metadata.subject.SubjectDomain)
	 */
	@Override
	public void setOwner(SubjectDomain owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.SubjectSet#getOwner()
	 */
	@Override
	public SubjectDomain getOwner() {
		return owner;
	}
	
}
