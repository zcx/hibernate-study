package Metadata.metamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MetaLinkPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "SLOT1ID", length = 32)
	private String slot1id;

	@Column(name = "SLOT2ID", length = 32)
	private String slot2id;

	public void setSlot1id(String slot1id) {
		this.slot1id = slot1id;
	}

	public String getSlot1id() {
		return slot1id;
	}

	public void setSlot2id(String slot2id) {
		this.slot2id = slot2id;
	}

	public String getSlot2id() {
		return slot2id;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
