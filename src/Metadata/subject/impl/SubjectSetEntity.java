package Metadata.subject.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Metadata.metamodel.impl.MetaObjectEntity;
import Metadata.subject.Subject;
import Metadata.subject.SubjectDomain;
import Metadata.subject.SubjectSet;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="HBSubjectSet")
public class SubjectSetEntity extends MetaObjectEntity implements SubjectSet {
	
	@OneToMany
	private Set<Subject> subjects = new HashSet<Subject>();
	
	@ManyToOne
	@JoinColumn(name="DOMAINID")
	private SubjectDomain owner = null;

	@Override
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public Set<Subject> getSubjects() {
		return subjects;
	}

	@Override
	public void setOwner(SubjectDomain owner) {
		this.owner = owner;
	}

	@Override
	public SubjectDomain getOwner() {
		return owner;
	}
	
}
