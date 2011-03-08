package Metadata.rpt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Report extends Namespace {

	@Column(name = "NAME")
	private String name;

	@Column(name = "CAPTION")
	private String caption;

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

	public void setGroup(MGroup group) {
		this.setParent(group);
	}

	public MGroup getGroup() {
		return (MGroup) this.getParent();
	}

}
