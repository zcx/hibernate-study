package Metadata.subject.impl;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Metadata.metamodel.impl.MetaObjectEntity;
import Metadata.subject.SubjectDomain;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@Table(name="HBSubjectDomain")
public class SubjectDomainEntity extends MetaObjectEntity implements SubjectDomain {

}
