package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBManager {

//	private static String username = "sa";
//	private static String password = "123456";
//	private static String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=postcrossing;";
//	private static String dbConn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static String username = "root";
	private static String password = "123456";
	private static String dbURL = "jdbc:mysql://localhost:3306/practice";
	private static String dbConn = "com.mysql.jdbc.Driver";
	
	public static Connection initConnection() throws SQLException,
			ClassNotFoundException {

		Class.forName(dbConn);
		Connection conn = null;
		conn = DriverManager.getConnection(dbURL, username, password);
		return conn;

	}

	public static void close(Statement st, Connection conn) {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) {
//
//		try {
//			Connection conn = initConnection();
//			PreparedStatement st;
//			st = conn.prepareStatement("insert into personal (username"
//					+ ")values(?)");
//			st.setString(1, "111");
//			st.executeUpdate();
//			conn.close();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
