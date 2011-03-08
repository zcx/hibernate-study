package Metadata.rpt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MGroup extends Namespace {
	@Column(name = "ISGROUP")
	private boolean isgroup = false;

	public void setIsgroup(boolean isgroup) {
		this.isgroup = isgroup;
	}

	public boolean isIsgroup() {
		return isgroup;
	}
}
