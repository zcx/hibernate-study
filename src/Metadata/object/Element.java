package Metadata.object;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Element extends MetaObject{
	
}
