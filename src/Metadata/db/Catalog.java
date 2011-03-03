package Metadata.db;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="MDR_DB_CATALOG")
public class Catalog extends MetaObject{

}
