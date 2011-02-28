package Metadata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

/**
 * 为fuzhq分支添加部分代码，制造其与ISSUE0001的冲突，进行测试
 * @author classfoo
 *
 */
@Entity
@Table(name="DB_HBSLOT")
public class HBSlot {
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@Version
	@Column(name="VERSION")
	private int version;
	
	public String getID(){
		return this.id;
	}
	
	public void setID(String id){
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}
	
	
}
