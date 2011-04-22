package Metadata.test.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TOBJECT")
public class TObject {
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	private String id = null;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}