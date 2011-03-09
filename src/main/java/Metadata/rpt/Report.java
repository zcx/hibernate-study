package Metadata.rpt;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Report extends Namespace {
	
	@Column(name = "CAPTION")
	private String caption;

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}

}
