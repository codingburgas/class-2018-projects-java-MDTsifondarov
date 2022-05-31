package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibrarianFunctionsForBooks extends Connecting {

	public LibrarianFunctionsForBooks() throws SQLException {
		super();
	}

	public void addBook(String title, String publisher, String genre, String author, String year) throws SQLException {
		String query1 = String
				.format("INSERT INTO Books ([Book_title] ,[Book_publisher],[Book_genre],[Book_author],[Published_year])"
						+ "VALUES (?,?,?,?,?)");

		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setString(1, title);
		stmt.setString(2, publisher);
		stmt.setString(3, genre);
		stmt.setString(4, author);
		stmt.setString(5, year);
		@SuppressWarnings("unused")
		int rs = stmt.executeUpdate();

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

	// update the author and the title of the book with id "id"
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
