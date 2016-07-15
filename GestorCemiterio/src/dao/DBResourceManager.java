package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBResourceManager {
//	private static String JDBC_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
//	private static String JDBC_URL = "jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=BD_cemiterio7;namedPipes=true";
//	private static String USER = "root";
//	private static String PASSWORD = "root";

	 private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 private static String JDBC_URL = "jdbc:mysql://127.8.12.2:3306/gerenciar";
	 private static String USER = "admineMuzzsQ";
	 private static String PASSWORD = "KyWvbDR2cxeu";

	private static DBResourceManager instancia;
	private Connection con;

	public DBResourceManager() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}

	public static DBResourceManager getInstance() throws ClassNotFoundException, SQLException {
		if (instancia == null) {
			instancia = new DBResourceManager();
		}
		return instancia;
	}

	public Connection getCon() {
		return con;
	}

}