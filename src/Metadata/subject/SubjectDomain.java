package Metadata.subject;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="MDR_SUBJECT_DOMAIN")
public class SubjectDomain extends MetaObject{

}
