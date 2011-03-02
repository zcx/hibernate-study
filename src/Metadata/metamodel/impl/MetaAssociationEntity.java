package Metadata.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HBASSOCIATION")
public class MetaAssociationEntity {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@ManyToOne
	private MetaAttributeEntity end1 = null;
	
	@ManyToOne
	private MetaAttributeEntity end2 = null;
	
	@OneToMany
	private List<MetaLinkEntity> links = new ArrayList<MetaLinkEntity>();

	public void setEnd1(MetaAttributeEntity end1) {
		this.end1 = end1;
	}

	public MetaAttributeEntity getEnd1() {
		return end1;
	}

	public void setEnd2(MetaAttributeEntity end2) {
		this.end2 = end2;
	}

	public MetaAttributeEntity getEnd2() {
		return end2;
	}

	public void setLinks(List<MetaLinkEntity> links) {
		this.links = links;
	}

	public List<MetaLinkEntity> getLinks() {
		return links;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
