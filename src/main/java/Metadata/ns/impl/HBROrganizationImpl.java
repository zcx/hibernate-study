package Metadata.ns.impl;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.criterion.DetachedCriteria;

import Metadata.ns.Namespace;
import Metadata.ns.Organization;

@Entity(name="Organization")
@Table(name="Organization")
@FilterJoinTable(name="HBRFileObjectImpl")
public final class HBROrganizationImpl extends HBRNamespaceImpl implements Organization{
	
	private static final String ENTITYNAME = "Organization";
	
	@Column(name="GOVERNOR", length=50)
	private String governor;
	
	@Column(name="TEL", length=30)
	private String tel;
	
	@Column(name="DESCRIPTION", length=100)
	private String description;
	
	public HBROrganizationImpl(Session session, Namespace parent, String name) {
		super(session, parent, name);
	}

	@Override
	public void getSuper() {

	}

	@Override
	public Set<Organization> getSubs() {
		return null;
	}

	@Override
	protected String getEntityName() {
		return ENTITYNAME;
	}

	@Override
	protected DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(HBROrganizationImpl.class);
	}

	public void setGovernor(String governor) {
		this.governor = governor;
	}

	public String getGovernor() {
		return governor;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
