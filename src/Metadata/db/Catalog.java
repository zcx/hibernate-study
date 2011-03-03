package Metadata.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

@Entity
@PrimaryKeyJoinColumn(name="CATALOGID", referencedColumnName="ID")
@Table(name="MDR_DB_CATALOG")
public class Catalog extends MetaObject{
	
	@OneToMany
	private Set<Schema> schemas = new HashSet<Schema>();

	public void setSchemas(Set<Schema> schemas) {
		this.schemas = schemas;
	}

	public Set<Schema> getSchemas() {
		return schemas;
	}
}
