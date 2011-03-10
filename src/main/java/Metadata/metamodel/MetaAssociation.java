package Metadata.metamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MDR_META_ASSOCIATION")
public class MetaAssociation {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@ManyToOne
	@JoinColumn(name="END1")
	private MetaAttribute end1 = null;

	@ManyToOne
	@JoinColumn(name="END2")
	private MetaAttribute end2 = null;

	@OneToMany(mappedBy="type")
	private List<MetaLink> links = new ArrayList<MetaLink>();

	public void setEnd1(MetaAttribute end1) {
		this.end1 = end1;
	}

	public MetaAttribute getEnd1() {
		return end1;
	}

	public void setEnd2(MetaAttribute end2) {
		this.end2 = end2;
	}

	public MetaAttribute getEnd2() {
		return end2;
	}

	public void setLinks(List<MetaLink> links) {
		this.links = links;
	}

	public List<MetaLink> getLinks() {
		return links;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
