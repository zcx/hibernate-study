package zcx.propertyconfig;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.cfg.Configuration;

import junit.framework.TestCase;

/**
 * 此类用于说明Hibernate中方言，缓存等属性怎么设置。具体设置方法如下：
 * <ol>
 *   <li>在/hibernate.properties中配置
 *   <li>通过设置jvm参数来配置，形式为java -Dproperty=value
 *   <li>在hibernate.cfg.xml中用property标签设置
 *   <li>调用Configuration.setProperty()
 *   <li>调用Configuration.addProperties()
 *   <li>调用Configuration.mergeProperties()
 *   <li>调用Configuration.setProperties()
 * </ol>
 * @author zhuchx
 *
 */
public class TestPropertiesConfig extends TestCase {
	/**
	 * 测试设置jvm参数来配置hibernate属性
	 * 注意：此方法必须在所有测试单元中第一个执行，因为jvm参数是在Environment中的静态块载入的，只会读取一次。
	 */
	public void testJvmProperty() throws IOException {
		String propName = "custm.config.jvm.param";
		String propValue = "jvm.property";
		System.setProperty(propName, propValue);
		Configuration conf = new Configuration();
		assertEquals(conf.getProperty(propName), propValue);
	}

	/**
	 * 测试在/hibernate.properties中配置hibernate的属性，在该文件中定义了属性
	 * custom.config.properties=file.hibernate.properties
	 */
	public void testFileHibernateProperties() {
		Configuration conf = new Configuration();
		assertEquals(conf.getProperty("custom.config.properties"), "file.hibernate.properties");
	}

	/**
	 * 测试在hibernate.cfg.xml中配置hibernate的熟悉，在该文件中定义了属性
	 * <property name="custom.config.hibernatecfg">file.hibernate.cfg.xml</property>
	 */
	public void testFileHibernateCfgXml() {
		Configuration conf = new Configuration().configure("/zcx/propertyconfig/propertyconfig-hibernate.cfg.xml");
		assertEquals(conf.getProperty("custom.config.hibernatecfg"), "file.hibernate.cfg.xml");
	}

	/**
	 * 测试调用Configuration.setProperty设置属性
	 * 注意：如果已经存在的属性，会被新设置的属性覆盖
	 */
	public void testConfSetProperty() {
		String propName = "custm.config.setproperty";
		String propValue = "setproperty";
		Configuration conf = new Configuration();
		conf.setProperty(propName, propValue);
		assertEquals(conf.getProperty(propName), propValue);
	}

	/**
	 * 测试调用Configuration.addProperties设置属性
	 * 注意：如果已经存在的属性，会被传入的Properties中的属性覆盖
	 */
	public void testConfAddProperties() {
		String propName = "custm.config.addProperties";
		String propValue = "addProperties";
		Properties props = new Properties();
		props.put(propName, propValue);

		Configuration conf = new Configuration();
		conf.addProperties(props);
		assertEquals(conf.getProperty(propName), propValue);
	}

	/**
	 * 测试调用Configuration.mergeProperties设置属性
	 * 注意：如果已经存在的属性，不会被传入的Properties中的属性覆盖
	 */
	public void testConfMergeProperties() {
		String propName = "custm.config.mergeProperties";
		String propValue = "mergeProperties";
		Properties props = new Properties();
		props.put(propName, propValue);

		Configuration conf = new Configuration();
		conf.mergeProperties(props);
		assertEquals(conf.getProperty(propName), propValue);
	}

	/**
	 * 测试调用Configuration.setProperties设置属性
	 * 注意：调用Configuration.setProperties设置属性会将其他地方设置的属性全部去除，只剩下传入的Properties中的属性
	 */
	public void testConfSetProperties() {
		String propName = "custm.config.setProperties";
		String propValue = "setProperties";
		Properties props = new Properties();
		props.put(propName, propValue);

		Configuration conf = new Configuration();
		conf.setProperties(props);
		assertEquals(conf.getProperty(propName), propValue);
	}
}
