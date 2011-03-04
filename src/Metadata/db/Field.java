package Metadata.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Metadata.metamodel.MetaObject;

@Entity
@javax.persistence.Table(name = "MDR_DB_FIELD")
public class Field extends MetaObject {
	@Column(name = "LEN", length = 64, nullable = true, scale = 0)
	private int len;

	@Column(name = "SCALE", length = 64, nullable = true, scale = 0)
	private int scale;

	@Column(name = "NULLABLE", nullable=false, unique=false)
	private int nullable;

	@Column(name = "ISUNIQUE")
	private int unique;
	
	@ManyToOne
	@JoinColumn(name="TABLEID")
	private Table owner = null;

	public void setLen(int len) {
		this.len = len;
	}

	public int getLen() {
		return len;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return scale;
	}

	public void setNullable(int nullable) {
		this.nullable = nullable;
	}

	public int getNullable() {
		return nullable;
	}

	public void setUnique(int unique) {
		this.unique = unique;
	}

	public int getUnique() {
		return unique;
	}

	public void setOwner(Table owner) {
		this.owner = owner;
	}

	public Table getOwner() {
		return owner;
	}
}
