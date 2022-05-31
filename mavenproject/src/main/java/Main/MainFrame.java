package Main;

import DB.LibrarianFunctionsForBooks;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.sql.SQLException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MainFrame {

	public static void main(String[] args) throws SQLException {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
		

		  LibrarianFunctionsForBooks usr = new LibrarianFunctionsForBooks();
          usr.showBooks();
          System.out.println();
          usr.addBook("gz", "gz", "gz", "zg", "zg");
          usr.showBooks();
          
	}
}
