package Metadata.subject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import Metadata.metamodel.MetaObject;

/**
 * HBSubject类描述了一个主题表对象，主题表包含名称，所属主题集，包含的主题表字段
 * @author classfoo
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "MDR_SUBJECT_SUBJECT")
@PrimaryKeyJoinColumn(name="ID",referencedColumnName="ID")  
//@NamedQueries({
//		//下面代码是无效的
//		@NamedQuery(name = "SelectSubject", query = "select new Subject(id) from Subject"),
//		@NamedQuery(name = "CountSelectAricle", query = "select count(*) from Aricle"),
//		@NamedQuery(name = "findAriclebyId", query = "select new Aricle(id,title,subTitle,hits,addTime,tag) from Aricle where id=?"),
//		@NamedQuery(name = "SelectAricleWithCategory", query = "select new Aricle(id,title,subTitle,hits,addTime,category) from Aricle aricle"),
//		@NamedQuery(name = "SelectAricleWithCategoryId", query = "select new Aricle(id,title,subTitle,hits,addTime,category.id) from Aricle aricle") })
public class Subject extends MetaObject {

	@Column(name = "NAME")
	private String name = null;

	@Column(name = "CAPTION")
	private String caption = null;

	@OneToMany(mappedBy="owner")
	private Set<SubjectField> fields = new HashSet<SubjectField>();

	@ManyToOne
	@JoinColumn(name = "SUBJECTSETID")
	private SubjectSet owner = null;

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

	public void setFields(Set<SubjectField> fields) {
		this.fields = fields;
	}

	public Set<SubjectField> getFields() {
		return fields;
	}

	public void setOwner(SubjectSet owner) {
		this.owner = owner;
	}

	public SubjectSet getOwner() {
		return owner;
	}
}
