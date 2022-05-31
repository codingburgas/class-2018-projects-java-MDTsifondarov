package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibrarianFunctionsForUsers extends Connecting {

	public LibrarianFunctionsForUsers() throws SQLException {
		super();
	}

	public void addUser(String fname, String lname, int age, String gender, String email, String password)
			throws SQLException {
		String query1 = String
				.format("INSERT INTO Users ([FirstName],[LastName],[Age],[Gender],[StudentEmail],[StudentPassword])"
						+ "VALUES (?,?,?,?,?,?)");

		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setString(1, fname);
		stmt.setString(2, lname);
		stmt.setInt(3, age);
		stmt.setString(4, gender);
		stmt.setString(5, email);
		stmt.setString(5, password);
		@SuppressWarnings("unused")
		int rs = stmt.executeUpdate();

	}

	public void showUsers() throws SQLException {
		String query1 = "SELECT * FROM Users";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {

			String custFmt = String.format("%d %s %s %d %s %s %s", rs.getInt("User_id"), rs.getString("FirstName"),
					rs.getString("LastName"), rs.getInt("Age"), rs.getString("Gender"), rs.getString("StudentEmail"),
					rs.getString("StudentPassword"));

			System.out.println(custFmt);

		}
	}

	public void showUsersByID(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM Users " + "WHERE User_id = " + idStr;
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {

			String custFmt = String.format("%d %s %s %d %s %s %s", rs.getInt("User_id"), rs.getString("FirstName"),
					rs.getString("LastName"), rs.getInt("Age"), rs.getString("Gender"), rs.getString("StudentEmail"),
					rs.getString("StudentPassword"));

			System.out.println(custFmt);
		}
	}

	public void updateUser(int id, String FirstName, String LastName) throws SQLException {
		String query1 = "UPDATE Users " + "SET FirstName = ?, LastName = ? " + " WHERE User_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setString(1, FirstName);
		stmt.setString(2, LastName);
		stmt.setInt(3, id);

		@SuppressWarnings("unused")
		int rs = stmt.executeUpdate();

	}

	public void deleteUser(Integer id) throws SQLException {
		String query1 = "DELETE FROM Users " + " WHERE User_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, id);

		@SuppressWarnings("unused")
		int rs = stmt.executeUpdate();

	}

}
