package Metadata.rpt;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Directory extends Namespace {
	@Column(name="DEEP")
	private int deep;

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public int getDeep() {
		return deep;
	}
}
