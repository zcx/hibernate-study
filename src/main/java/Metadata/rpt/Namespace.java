package Metadata.rpt;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "MDR_RPT_NAMESPACE")
@IdClass(NamespacePK.class)
public class Namespace {

	@Column(name = "ISROOT")
	private boolean isRoot;

	@Id
	private String name = null;

	@Id
	private String parent = null;

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getParent() {
		return parent;
	}

}

@Embeddable
class NamespacePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NAME", length = 32)
	private String name = null;

	@Id
	@Column(name = "PARENT", length = 32)
	private String parent = null;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getParent() {
		return parent;
	}
}
