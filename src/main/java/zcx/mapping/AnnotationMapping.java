package zcx.mapping;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "MappingTable")
public class AnnotationMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_")
	private long id;

	private String title;

	public AnnotationMapping() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
