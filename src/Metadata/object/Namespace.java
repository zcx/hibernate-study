package Metadata.object;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "MDR_RPT_NAMESPACE")
//, uniqueConstraints = { @UniqueConstraint(columnNames = { "parent", "name" }) })
@IdClass(NamespacePK.class)
@NamedQuery(name="aaaa", query="")
public class Namespace {

	@Id
	private String pid;

	@Id
	private String nid;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "nid")
	private NSName name = null;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "pid")
	private NSParent parent = null;

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return pid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNid() {
		return nid;
	}

	public void setName(NSName name) {
		this.name = name;
	}

	public NSName getName() {
		return name;
	}

	public void setParent(NSParent parent) {
		this.parent = parent;
	}

	public NSParent getParent() {
		return parent;
	}
}

@Embeddable
class NamespacePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nid", length = 32, insertable=false, updatable=false)
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String nid = null;

	@Id
	@Column(name = "pid", length = 32,  insertable=false, updatable=false)
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String pid = null;

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNid() {
		return nid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPid() {
		return pid;
	}

}