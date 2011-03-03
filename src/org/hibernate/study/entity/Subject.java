package org.hibernate.study.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MySubject")
public class Subject {
	private String uid;

	private String name;

	private String title;

	public void setUid(String id) {
		this.uid = id;
	}

	@Id
	public String getUid() {
		return uid;
	}

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
