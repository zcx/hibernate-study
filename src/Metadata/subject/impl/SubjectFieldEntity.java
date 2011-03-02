package Metadata.subject.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import Metadata.subject.SubjectField;

@Entity
@Table(name="HBField")
public class SubjectFieldEntity implements SubjectField {
	
	private int len;

	private int scale;

	private boolean isNullable;

	private boolean isUnique;
}
