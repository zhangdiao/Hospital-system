package hospital.util;


import java.sql.Connection;
import java.sql.DriverManager;

//获取数据库连接
public class JdbcUtil {

	public static Connection getConnection() {
		Connection con = null;
		// 数据库驱动
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// 连接的数据库
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=master";
		String userName = "sa";// 数据库用户名
		String userPwd = "123456";// 数据库密码
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (Exception e) {
			System.out.println("获取连接失败." + e.getMessage());
		}
		return con;
	}
	


}
