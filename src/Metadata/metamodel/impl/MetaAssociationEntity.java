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

import Metadata.metamodel.MetaAssociation;
import Metadata.metamodel.MetaAttribute;
import Metadata.metamodel.MetaLink;

@Entity
@Table(name = "HBASSOCIATION")
public class MetaAssociationEntity implements MetaAssociation {

	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@ManyToOne
	private MetaAttribute end1 = null;

	@ManyToOne
	private MetaAttribute end2 = null;

	@OneToMany
	private List<MetaLink> links = new ArrayList<MetaLink>();

	@Override
	public void setEnd1(MetaAttribute end1) {
		this.end1 = end1;
	}

	@Override
	public MetaAttribute getEnd1() {
		return end1;
	}

	@Override
	public void setEnd2(MetaAttribute end2) {
		this.end2 = end2;
	}

	@Override
	public MetaAttribute getEnd2() {
		return end2;
	}

	@Override
	public void setLinks(List<MetaLink> links) {
		this.links = links;
	}

	@Override
	public List<MetaLink> getLinks() {
		return links;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

}
