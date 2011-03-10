package dw.dbpool;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class TestC3p0 extends TestDbpool {

	protected SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.setProperty(Environment.URL, "jdbc:oracle:thin:@192.168.1.100:1521:esenbi");
		conf.setProperty(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
		conf.setProperty(Environment.USER, "test");
		conf.setProperty(Environment.PASS, "test");
		//conf.setProperty(Environment.DIALECT, "");注释掉是因为常见的数据库可以自动识别；
		conf.setProperty(Environment.SHOW_SQL, "true");
		conf.setProperty(Environment.HBM2DDL_AUTO, "update");
		
		conf.setProperty(Environment.C3P0_MAX_SIZE, "20");
		conf.setProperty(Environment.C3P0_MIN_SIZE, "1");
		conf.setProperty(Environment.C3P0_TIMEOUT, "5000");
		conf.setProperty(Environment.C3P0_MAX_STATEMENTS, "50");
		return conf.buildSessionFactory();
	}

}
