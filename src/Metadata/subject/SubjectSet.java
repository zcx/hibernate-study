package Metadata.subject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "HBSubjectSet")
public class SubjectSet extends MetaObject {

	@OneToMany
	private Set<Subject> subjects = new HashSet<Subject>();

	@ManyToOne
	@JoinColumn(name = "DOMAINID")
	private SubjectDomain owner = null;

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setOwner(SubjectDomain owner) {
		this.owner = owner;
	}

	public SubjectDomain getOwner() {
		return owner;
	}

}
