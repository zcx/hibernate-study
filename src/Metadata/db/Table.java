package Metadata.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Metadata.metamodel.MetaObject;

@Entity
@javax.persistence.Table(name = "MDR_DB_TABLE")
public class Table extends MetaObject{
	
	@OneToMany(mappedBy="owner")
	private List<Field> fields = new ArrayList<Field>();
	
	@ManyToOne
	@JoinColumn(name="SCHEMAID")
	private Schema owner = null;

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setOwner(Schema owner) {
		this.owner = owner;
	}

	public Schema getOwner() {
		return owner;
	}
}