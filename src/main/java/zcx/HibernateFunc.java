package zcx;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.connection.ConnectionProviderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * 提供Hibernate测试中常用的方法
 * @author zhuchx
 */
public class HibernateFunc {
	/**
	 * 设置数据库连接池的设置
	 */
	public static void setDataSourceProperty(Configuration conf) {
		Properties props = new Properties();
		props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3307/hibernate?useUnicode=true&amp;characterEncoding=utf8");
		props.put(Environment.USER, "hibernate");
		props.put(Environment.PASS, "hibernate");
		props.put(Environment.POOL_SIZE, "1");
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		conf.mergeProperties(props);
	}

	/**
	 * 判断数据库中是否存在表tableName
	 * @param conf
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public static boolean isTableExist(Configuration conf, String tableName) throws Exception {
		ConnectionProvider conPro = getConnection(conf);
		try {
			Connection con = conPro.getConnection();
			try {
				DatabaseMetaData md = con.getMetaData();
				ResultSet rs = md.getTables(null, null, tableName, null);
				try {
					return rs.next();
				}
				finally {
					rs.close();
				}
			}
			finally {
				conPro.closeConnection(con);
			}
		}
		finally {
			conPro.close();
		}
	}

	/**
	 * 删除数据库中的表
	 * @param conf
	 * @param tableName
	 * @throws Exception
	 */
	public static void dropTable(Configuration conf, String tableName) throws Exception {
		ConnectionProvider conPro = getConnection(conf);
		try {
			String sql = "drop table " + tableName;
			Connection con = conPro.getConnection();
			try {
				Statement sm = con.createStatement();
				try {
					sm.executeUpdate(sql);
				}
				finally {
					sm.close();
				}
			}
			finally {
				conPro.closeConnection(con);
			}
		}
		finally {
			conPro.close();
		}
	}

	/**
	 * 返回数据库中的所有表
	 * @param conf
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public static String[] getTables(Configuration conf) throws Exception {
		ConnectionProvider conPro = getConnection(conf);
		try {
			Connection con = conPro.getConnection();
			try {
				ArrayList<String> list = new ArrayList<String>();
				DatabaseMetaData md = con.getMetaData();
				ResultSet rs = md.getTables(null, null, null, null);
				try {
					while (rs.next()) {
						list.add(rs.getString("TABLE_NAME"));
					}
				}
				finally {
					rs.close();
				}
				if (list.size() == 0)
					return null;
				return list.toArray(new String[list.size()]);
			}
			finally {
				conPro.closeConnection(con);
			}
		}
		finally {
			conPro.close();
		}
	}

	/**
	 * 获得连接池接口
	 * @param conf
	 * @return
	 * @throws Exception
	 */
	public static ConnectionProvider getConnection(Configuration conf) throws Exception {
		return ConnectionProviderFactory.newConnectionProvider(conf.getProperties());
		//		String driver = conf.getProperty(Environment.DRIVER);
		//		String url = conf.getProperty(Environment.URL);
		//		String user = conf.getProperty(Environment.USER);
		//		String pass = conf.getProperty(Environment.PASS);
		//		Class.forName(driver);
		//		return DriverManager.getConnection(url, user, pass);
	}

	/**
	 * 返回指定类的class文件路径。注意：此方法只适用于文件在本地的情况，并且不是在jar中
	 * @param c
	 * @return
	 */
	public static File getClassAbsolutePath(Class c) {
		String path = c.getProtectionDomain().getCodeSource().getLocation().getPath();
		String name = c.getName().replaceAll("\\.", "/");
		return new File(path + name + ".class");
	}

	/**
	 * 返回指定类所在的包，包间以/分隔，主要用于确定hbm文件的路径
	 * @param c
	 * @return
	 */
	public static String getPackageAsPath(Class c) {
		Package pkg = c.getPackage();
		return pkg == null ? "" : pkg.getName().replaceAll("\\.", "/");
	}

	public static Document getDocument(InputStream in) throws Exception {
		InputSource source = new InputSource(in);
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(source);
	}

	/**
	   * 从一个流中复制指定的长度的类容到另一个流中,如果从源流中不能再读入数据则返回复制了的数据的字节数
	   */
	static private final int BUF_SIZE = 1024 * 8;

	public static int stmTryCopyFrom(InputStream in, OutputStream out) throws IOException {
		byte[] buf = new byte[BUF_SIZE];
		int sz = 0;
		int r;
		while ((r = in.read(buf)) != -1) {
			sz += r;
			out.write(buf, 0, r);
		}
		return sz;
	}

	/**
	   * 将流中的所有信息读出并以byte数组的形式返回
	   */
	public static final byte[] stm2bytes(InputStream in) throws IOException {
		int available = in.available();
		if (available <= 0)
			available = 5 * 1024;
		ByteArrayOutputStream out = new ByteArrayOutputStream(available);
		stmTryCopyFrom(in, out);
		//如果out.getBuf().length==out.size()那么直接返回buf即可，不必再次复制内存块
		return out.toByteArray();
	}

	public static final String stm2Str(InputStream in, String charsetName) throws IOException {
		return new String(stm2bytes(in), charsetName);
	}

	public static final String UTF8 = "UTF-8";

}
