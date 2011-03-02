package Metadata.subject.impl;

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

import Metadata.subject.Subject;
import Metadata.subject.SubjectField;
import Metadata.subject.SubjectSet;

/**
 * HBSubject类描述了一个主题表对象，主题表包含名称，所属主题集，包含的主题表字段
 * @author classfoo
 *
 */
@Entity
@Table(name="HBSubject")
public class SubjectEntity implements Subject {
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id = null;
	
	@Id
	@Column(name="VERSION")
	private int version;
	
	@Column(name="NAME")
	private String name = null;
	
	@Column(name="CAPTION")
	private String caption = null;
	
	@OneToMany
	private List<SubjectField> fields = new ArrayList<SubjectField>();
	
	@ManyToOne
	@JoinColumn(name="SUBJECTSETID")
	private SubjectSet owner = null;

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#setVersion(int)
	 */
	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#getVersion()
	 */
	@Override
	public int getVersion() {
		return version;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#setCaption(java.lang.String)
	 */
	@Override
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#getCaption()
	 */
	@Override
	public String getCaption() {
		return caption;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#setFields(java.util.List)
	 */
	@Override
	public void setFields(List<SubjectField> fields) {
		this.fields = fields;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#getFields()
	 */
	@Override
	public List<SubjectField> getFields() {
		return fields;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#setOwner(Metadata.subject.SubjectSetEntity)
	 */
	@Override
	public void setOwner(SubjectSet owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see Metadata.subject.Subject#getOwner()
	 */
	@Override
	public SubjectSet getOwner() {
		return owner;
	}
}
