package utilitiesConfig;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnUtils {
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String sqlInstanceName="SQLEXPRESS";
		String dbName = "automationfc";
		String userName = "root";
		String password = "automationfc";
		return getSQLServerConnection(hostName, sqlInstanceName,dbName, userName, password);
	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String dbName, String userName, String password){
		Connection conn = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + dbName + ";instance=" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
