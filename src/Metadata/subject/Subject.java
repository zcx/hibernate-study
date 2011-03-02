package Metadata.subject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import Metadata.metamodel.MetaObject;

/**
 * HBSubject类描述了一个主题表对象，主题表包含名称，所属主题集，包含的主题表字段
 * @author classfoo
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@Table(name="HBSubject")
public class Subject extends MetaObject{
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id = null;
	
	@Version
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


	public void setId(String id) {
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public int getVersion() {
		return version;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public String getCaption() {
		return caption;
	}


	public void setFields(List<SubjectField> fields) {
		this.fields = fields;
	}


	public List<SubjectField> getFields() {
		return fields;
	}


	public void setOwner(SubjectSet owner) {
		this.owner = owner;
	}


	public SubjectSet getOwner() {
		return owner;
	}
}
