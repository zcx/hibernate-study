package Metadata.ns.impl;

import java.io.InputStream;
import java.io.OutputStream;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.PolymorphismType;
import org.hibernate.criterion.DetachedCriteria;

import Metadata.ns.FileObject;

@Entity(name="FileObject")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true, polymorphism=PolymorphismType.EXPLICIT)
@Table(name = "FileObject", uniqueConstraints = {
		//@UniqueConstraint(columnNames="LFT"),
		//@UniqueConstraint(columnNames="RGT")
})
@FilterJoinTable(name="HBROrganizationImpl")
public final class HBRFileObjectImpl extends HBRNamespaceImpl implements FileObject {
	
	private static final String ENTITYNAME = "FileObject";
		
	@Column(name = "ISDIR")
	private boolean isdir;

	@Column(name = "CONTENT")
	@Basic(fetch = FetchType.LAZY)
	private byte[] content;

	public HBRFileObjectImpl(Session session, HBRFileObjectImpl parent, String name, boolean isdir) {
		super(session, parent, name);
		this.setIsdir(isdir);
		Query q = session.createQuery("update FileObject set LFT = 1 where LFT <> 1");
		//Query q = session.createQuery("select p from FileObject as p where LFT = 1");
		q.executeUpdate();
	}

	public void setIsdir(boolean isdir) {
		this.isdir = isdir;
	}

	public boolean isIsdir() {
		return isdir;
	}

	@Override
	public void writeTo(OutputStream os) {

	}

	@Override
	public InputStream read() {
		return null;
	}

	protected void setContent(byte[] content) {
		this.content = content;
	}

	protected byte[] getContent() {
		return content;
	}

	@Override
	protected String getEntityName() {
		return ENTITYNAME;
	}

	@Override
	protected DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(HBRFileObjectImpl.class);
	}

}
