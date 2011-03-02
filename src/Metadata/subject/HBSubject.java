package Metadata.subject;

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

/**
 * HBSubject类描述了一个主题表对象，主题表包含名称，所属主题集，包含的主题表字段
 * @author classfoo
 *
 */
@Entity
@Table(name="HBSubject")
public class HBSubject {
	
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
	private List<HBSubjectField> fields = new ArrayList<HBSubjectField>();
	
	@ManyToOne
	@JoinColumn(name="SUBJECTSETID")
	private HBSubjectSet owner = null;

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

	public void setFields(List<HBSubjectField> fields) {
		this.fields = fields;
	}

	public List<HBSubjectField> getFields() {
		return fields;
	}

	public void setOwner(HBSubjectSet owner) {
		this.owner = owner;
	}

	public HBSubjectSet getOwner() {
		return owner;
	}
}
