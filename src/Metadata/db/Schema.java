package Metadata.db;

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
@Table(name = "MDR_DB_SCHEMA")
public class Schema extends MetaObject {

	@OneToMany
	private Set<Table> tables = new HashSet<Table>();

	@ManyToOne
	@JoinColumn(name = "CATALOGID")
	private Catalog owner = null;

	public void setTables(Set<Table> tables) {
		this.tables = tables;
	}

	public Set<Table> getTables() {
		return tables;
	}

	public void setOwner(Catalog owner) {
		this.owner = owner;
	}

	public Catalog getOwner() {
		return owner;
	}
}
