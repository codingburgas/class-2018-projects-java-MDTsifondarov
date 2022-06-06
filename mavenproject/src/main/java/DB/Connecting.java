package DB;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Connecting{
	private String url = "jdbc:sqlserver://SD2310\\sqlexpress;databaseName=Library;integratedSecurity=true";
	protected Connection conn;

	public Connecting() throws SQLException {
		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");
	}

	public void CloseConnecton() throws SQLException {
		conn.close();
	}
	
}
