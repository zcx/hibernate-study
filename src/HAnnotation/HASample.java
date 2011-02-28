package HAnnotation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @javax.persistence.Entity 声明为一个实体
 * @javax.persistence.Table(name = "hasample") 为实体指定数据库表名(表名="XXX")
 * 上面两个Annotation在Hibernate中也有定义，不能使用Hibernate中的定义，否则测试不成功
 * 
 * @id 声明实体的标识属性
 * @GeneratedValue(strategy = GenerationType.AUTO)定义标识字段的生成策略
 * @Column(name = "SAMPLE_ID") 声明列(字段名="XXX")
 *
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "hasample")
public class HASample {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SAMPLE_ID")
	private long id;

	private String title;

	@Column(name = "SAMPLE_DATE")
	private Date date;

	public HASample() {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
