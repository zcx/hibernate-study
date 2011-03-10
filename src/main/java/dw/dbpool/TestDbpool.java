package dw.dbpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Settings;
import org.hibernate.classic.Session;
import org.hibernate.jdbc.Work;

import junit.framework.TestCase;

public abstract class TestDbpool extends TestCase {
	protected abstract SessionFactory getSessionFactory() ;
	

	/**
	 * 测试如何从Session中获取Connecion对象；
	 */
	public void testGetConnectionFromSession() {
		SessionFactory sf = getSessionFactory();
		try {
			Session ss = sf.openSession();
			try {
				Connection conn = ss.connection();//此方法已经过期
				//要直接使用connection需要调用如下方法：
				Work work = new Work() {
					@Override
					public void execute(Connection con) throws SQLException {
						Statement stat = con.createStatement();
						try{
							stat.executeQuery("select 1 from dual");
						}finally{
							stat.close();
						}
					}
				};
				ss.doWork(work);
			}
			finally {
				ss.close();
			}
		}
		finally {
			sf.close();
		}
	}
	
	/**
	 * 如何获取Dialect接口？
	 */
	public void testDialect(){
		
		
	}
}
