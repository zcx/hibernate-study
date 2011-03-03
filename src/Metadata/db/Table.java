package Metadata.db;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@javax.persistence.Table(name = "MDR_DB_TABLE")
public class Table extends MetaObject{

}
