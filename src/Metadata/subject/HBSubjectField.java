package Metadata.subject;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HBField")
public class HBSubjectField {
	
	private int len;

	private int scale;

	private boolean isNullable;

	private boolean isUnique;
}
