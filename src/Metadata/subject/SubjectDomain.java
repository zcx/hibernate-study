package Metadata.subject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="MDR_SUBJECT_DOMAIN")
public class SubjectDomain extends MetaObject{
	
	@OneToMany(mappedBy="owner")
	public Set<SubjectSet> sets = new HashSet<SubjectSet>();
}
