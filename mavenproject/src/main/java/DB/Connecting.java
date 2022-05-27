package DB;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Connecting {
	private String url = "jdbc:sqlserver://SD2310\\sqlexpress;databaseName=Library;integratedSecurity=true";
	private Connection conn;

	public Connecting() throws SQLException {
		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");
	}

	public void CloseConnecton() throws SQLException {
		conn.close();
	}
	
	public void showBooks() throws SQLException {
		String query1 = "SELECT TOP 3 * FROM Books";
		Statement stmt = conn.createStatement();



		ResultSet rs = stmt.executeQuery(query1);



		while (rs.next()) {


  
			
			
			
			
		String custFmt = String.format("%d %s %s %s %s", rs.getInt("Book_id")-1, rs.getString("book_title"),
		rs.getString("book_publisher"), rs.getString("book_genre"), rs.getString("book_author"),rs.getString("published_year"));



		System.out.println(custFmt);



		}
		}




		// shows the first name of the customer with id "id"
		/*public void showCustomersByID(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM Books " + "WHERE genre = " + idStr;
		Statement stmt = conn.createStatement();



		ResultSet rs = stmt.executeQuery(query1);



		while (rs.next()) {



		String custFmt = String.format("%d %s %s %s %s", rs.getInt("customer_id"), rs.getString("first_name"),
		rs.getString("last_name"), rs.getString("email"), rs.getString("state"));



		System.out.println(custFmt);
		}
		}



		// update the first name of the customer with id "id"
		public void updateCustomer(int id, String firstName, String lastName) throws SQLException {
		String query1 = "UPDATE sales.customers " + "SET first_name = ?, last_name = ? " + " WHERE customer_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setInt(3, id);



		int rs = stmt.executeUpdate();



		System.out.println(String.format("Rows affected: %d", rs));
		}



		public void deleteCustomers(Integer id) throws SQLException {
		String query1 = "DELETE FROM sales.customers " + " WHERE customer_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, id);
		int rs = stmt.executeUpdate();



		System.out.println(String.format("Rows affected: %d", rs));



		}*/
		


}
