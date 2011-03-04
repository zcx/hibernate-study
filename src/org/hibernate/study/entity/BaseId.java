package org.hibernate.study.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 提取所有实体的id生成策略
 * @author sam
 *
 */
@MappedSuperclass
public class BaseId {
	protected String id;

	public void setId(String id) {
		this.id = id;
	}

	@javax.persistence.Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

}
