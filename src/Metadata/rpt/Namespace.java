package Metadata.rpt;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="MDR_RPT_NAMESPACE")
public class Namespace extends MetaObject{

	@Column(name = "ISROOT")
	private boolean isRoot;

	@ManyToOne
	@JoinColumn(name = "PARENT")
	private Namespace parent;

	@OneToMany(mappedBy = "parent")
	private Set<Namespace> childs;

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public boolean isRoot() {
		return isRoot;
	}

	protected void setParent(Namespace parent) {
		this.parent = parent;
	}

	protected Namespace getParent() {
		return parent;
	}

	protected void setChilds(Set<Namespace> childs) {
		this.childs = childs;
	}

	protected Set<Namespace> getChilds() {
		return childs;
	}

}
