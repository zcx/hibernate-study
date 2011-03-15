package zcx.mapping;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;

import org.hibernate.cfg.Configuration;
import org.hibernate.util.xml.MappingReader;
import org.hibernate.util.xml.OriginImpl;
import org.hibernate.util.xml.XmlDocument;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import zcx.HibernateFunc;

/**
 * 此类测试将Hibernate的类映射到一个数据库表。定义方式如下：
 * <ol>
 *   <li>调用Configuration.addResource配置
 *   <li>调用Configuration.addClass配置
 *   <li>调用Configuration.addDirectory配置
 *   <li>调用Configuration.addFile配置
 *   <li>调用Configuration.addInputStream配置
 *   <li>调用Configuration.addDocument配置
 *   <li>调用Configuration.addXML配置
 *   <li>调用Configuration.addJar配置，未测试
 *   <li>调用Configuration.addURL配置
 *   <li>调用Configuration.addAnnotatedClass配置
 *   <li>调用Configuration.add配置
 *   <li>测试在hibernate.cfg.xml中使用<mapping>配置
 * </ol>
 * @author zhuchx
 */
public class TestMapping extends TestCase {

	private static final String MAPPING_EMPTY_CFG = "/" + HibernateFunc.getPackageAsPath(HibernateFunc.class)
			+ "/mapping-empty-hibernate.cfg.xml";

	private static final String TABLENAME = "MappingTable";

	private static final String HBM_XML_NAME = "CustomMapping.hbm.xml";

	private static final String HBM_XML = HibernateFunc.getPackageAsPath(CustomMapping.class) + "/" + HBM_XML_NAME;

	public static void main(String[] args) throws Exception {
		TestMapping test = new TestMapping();
		test.testConfPackage();
		System.out.println(HBM_XML);
	}

	/**
	 * 删除所有的数据库表
	 * @param conf
	 * @throws Exception 
	 */
	private void dropAllTables(Configuration conf) throws Exception {
		String[] tables = HibernateFunc.getTables(conf);
		if (tables == null || tables.length == 0)
			return;
		for (String tableName : tables) {
			HibernateFunc.dropTable(conf, tableName);
		}

		tables = HibernateFunc.getTables(conf);
		assertEquals(tables == null ? 0 : tables.length, 0);
	}

	/**
	 * 创建Configuration对象，并设置完成连接池参数，删除数据库中的所有表，方便后面测试
	 * @return
	 * @throws Exception
	 */
	private Configuration createConfigurate() throws Exception {
		Configuration conf = new Configuration();
		HibernateFunc.setDataSourceProperty(conf);
		dropAllTables(conf);
		return conf;
	}

	private InputStream getHbmXml() {
		return this.getClass().getResourceAsStream(HBM_XML_NAME);
	}

	/**
	 * 检查结果是否正确。当数据库中存在定义的数据库表时，认为配置正确
	 * @param conf
	 * @throws Exception 
	 */
	private void checkResult(Configuration conf) throws Exception {
		conf.buildSessionFactory();
		assertTrue(HibernateFunc.isTableExist(conf, TABLENAME));
	}

	/**
	 * 测试使用Configuration.addResource加入
	 * @throws Exception 
	 */
	public void testConfAddResource() throws Exception {
		Configuration conf = createConfigurate();
		conf.addResource(HBM_XML);
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addClass加入
	 * @throws Exception 
	 */
	public void testConfAddClass() throws Exception {
		Configuration conf = createConfigurate();
		conf.addClass(CustomMapping.class);
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试在hibernate.cfg.xml中使用<mapping>配置
	 * @throws Exception
	 */
	public void testConfHibernateCfgXml() throws Exception {
		Configuration conf = createConfigurate();
		String cfg = "/" + HibernateFunc.getPackageAsPath(this.getClass()) + "/mapping-hibernate.cfg.xml";
		conf.configure(cfg);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addDirectory加入
	 * @throws Exception 
	 */
	public void testConfDirectory() throws Exception {
		Configuration conf = createConfigurate();
		File file = HibernateFunc.getClassAbsolutePath(CustomMapping.class);
		conf.addDirectory(file.getParentFile());
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addFile加入
	 * @throws Exception
	 */
	public void testConfFile() throws Exception {
		Configuration conf = createConfigurate();
		String path = HibernateFunc.getClassAbsolutePath(CustomMapping.class).getParent() + "/" + HBM_XML_NAME;
		conf.addFile(path);
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addInputStream加入
	 * @throws Exception 
	 */
	public void testConfInputStream() throws Exception {
		Configuration conf = createConfigurate();
		InputStream in = getHbmXml();
		try {
			conf.addInputStream(in);
		}
		finally {
			in.close();
		}
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addDocument加入
	 * @throws Exception 
	 */
	public void testConfDocument() throws Exception {
		Configuration conf = createConfigurate();
		InputStream in = getHbmXml();
		try {
			Document doc = HibernateFunc.getDocument(in);
			conf.addDocument(doc);
		}
		finally {
			in.close();
		}
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addXML加入
	 * @throws Exception 
	 */
	public void testConfXML() throws Exception {
		Configuration conf = createConfigurate();
		InputStream in = getHbmXml();
		try {
			String xml = HibernateFunc.stm2Str(in, "UTF-8");
			conf.addXML(xml);
		}
		finally {
			in.close();
		}
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addJar加入
	 * @throws Exception 
	 */
	public void testConfJAR() throws Exception {
		//		Configuration conf = createConfigurate();
		//		conf.addJar(jar);
		//		conf.configure(MAPPING_EMPTY_CFG);
		//		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addURL加入
	 * @throws Exception 
	 */
	public void testConfURL() throws Exception {
		Configuration conf = createConfigurate();
		String url = "file:///" + HibernateFunc.getClassAbsolutePath(CustomMapping.class).getParent() + "/"
				+ HBM_XML_NAME;
		conf.addURL(new URL(url));
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addURL加入
	 * @throws Exception 
	 */
	public void testConfPackage() throws Exception {
		//addPackage不像是增加映射的
		//		Configuration conf = createConfigurate();
		//		String pkg = CustomMapping.class.getPackage().getName();
		//		conf.addPackage(pkg);
		//		conf.configure(MAPPING_EMPTY_CFG);
		//		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.addAnnotatedClass加入
	 * @throws Exception 
	 */
	public void testConfAnnotatedClass() throws Exception {
		Configuration conf = createConfigurate();
		conf.addAnnotatedClass(AnnotationMapping.class);
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}

	/**
	 * 测试使用Configuration.add加入
	 * @throws Exception 
	 */
	public void testConfXmlDocument() throws Exception {
		Configuration conf = createConfigurate();
		InputStream in = getHbmXml();
		try {
			InputSource inputSource = new InputSource(in);
			OriginImpl origin = new OriginImpl("file", HBM_XML);
			XmlDocument metadataXml = MappingReader.INSTANCE.readMappingDocument(conf.getEntityResolver(), inputSource,
					origin);
			conf.add(metadataXml);
		}
		finally {
			in.close();
		}
		conf.configure(MAPPING_EMPTY_CFG);
		checkResult(conf);
	}
}
