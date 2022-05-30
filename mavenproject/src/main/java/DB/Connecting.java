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
	private String url = "jdbc:sqlserver://SD2311\\sqlexpress;databaseName=Library;integratedSecurity=true";
	private Connection conn;

	public Connecting() throws SQLException {
		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");
	}

	public void CloseConnecton() throws SQLException {
		conn.close();
	}
	
	public void addBook(String title,String publisher,String genre,String author,String year) throws SQLException{
		String query1 = String.format(
				"INSERT INTO Books ([Book_title] ,[Book_publisher],[Book_genre],[Book_author],[Published_year])"+
				    "VALUES (?,?,?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query1);
		 stmt.setString(1,title);
		 stmt.setString(2,publisher);
		 stmt.setString(3,genre);
		 stmt.setString(4,author);
		 stmt.setString(5,year);
		int rs = stmt.executeUpdate();
			if(rs==1) {
				System.out.println(rs);
			}
	}

	public void showBooks() throws SQLException {
		String query1 = "SELECT * FROM Books";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {

			String custFmt = String.format("%d %s %s %s %s", rs.getInt("Book_id"), rs.getString("Book_title"),
					rs.getString("Book_publisher"), rs.getString("Book_genre"), rs.getString("Book_author"),
					rs.getString("Published_year"));

			System.out.println(custFmt);

		}
	}

	// shows the title of the book with id "id"
	public void showBooksByID(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM Books " + "WHERE Book_id = " + idStr;
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {

			String custFmt = String.format("%d %s %s %s %s", rs.getInt("Book_id"), rs.getString("Book_title"),
					rs.getString("Book_publisher"), rs.getString("Book_genre"), rs.getString("Book_author"),
					rs.getString("Published_year"));

			System.out.println(custFmt);
		}
	}

	// update the first name of the customer with id "id"
	public void updateBook(int id, String title, String author) throws SQLException {
		String query1 = "UPDATE Books " + "SET Book_title = ?, Book_author = ? " + " WHERE Book_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setString(1, title);
		stmt.setString(2, author);
		stmt.setInt(3, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	public void deleteBook(Integer id) throws SQLException {
		String query1 = "DELETE FROM Books " + " WHERE Book_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, id);
		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));

	}

}
