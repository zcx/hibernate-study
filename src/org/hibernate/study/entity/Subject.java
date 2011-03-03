package org.hibernate.study.entity;

import javax.persistence.Entity;

@Entity
public class Subject extends BaseId {

	private String name;

	private String title;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setTitle(String desc) {
		this.title = desc;
	}

	public String getTitle() {
		return title;
	}
}
