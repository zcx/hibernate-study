package Metadata.test.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TINSTANCE")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@IdClass(TInstance.PrimaryKey.class)
public abstract class TInstance {
	
	@Id
	private String name = null;
	
	@Id
	private TObject tobj = null;


	public void setTobj(TObject tobj) {
		this.tobj = tobj;
	}

	public TObject getTobj() {
		return tobj;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Embeddable
	public static class PrimaryKey implements Serializable {

		private static final long serialVersionUID = 7582481434712381494L;

		@Column(name="NAME")
		private String name = null;
		
		@Id
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="ID")
		//@PrimaryKeyJoinColumn(name="id")
		private TObject tobj = null;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setTobj(TObject tobj) {
			this.tobj = tobj;
		}

		public TObject getTobj() {
			return tobj;
		}


	}

}
