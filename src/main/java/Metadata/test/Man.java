package Metadata.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;


@Entity
public class Man extends Marriaged {

	@OneToMany(mappedBy = "man")
	@MapKey(name = "mankey")
	private Map<String, Woman> property = new HashMap<String, Woman>();
	
	public void setProperty(Map<String, Woman> property) {
		this.property = property;
	}

	public Map<String, Woman> getProperty() {
		return property;
	}
}