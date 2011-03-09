package Metadata.rpt;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
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
