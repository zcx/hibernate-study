package Metadata.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name="HBField")
public class SubjectField extends MetaObject{
	
	@Column(name="LEN")
	private int len;

	@Column(name="SCALE")
	private int scale;

	@Column(name="ISNULLABLE")
	private boolean isNullable;

	@Column(name="ISUNIQUE")
	private boolean isUnique;

	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	public boolean isUnique() {
		return isUnique;
	}

	public void setNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}

	public boolean isNullable() {
		return isNullable;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return scale;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getLen() {
		return len;
	}
}
