package org.hibernate.study.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Subject extends BaseEntity {

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
