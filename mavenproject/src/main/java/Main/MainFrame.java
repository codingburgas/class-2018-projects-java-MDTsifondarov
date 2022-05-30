package Main;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.Connecting;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class MainFrame {

	public static void main(String[] args) throws SQLException {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
		// System.out.println(System.getProperty("file.encoding"));

		  Connecting conn = new Connecting();
          conn.showBooks();
          System.out.println();
          conn.addBook("asd", "asd", "asd", "asd", "asd");
          conn.addBook("asd1", "asd1", "asd1", "asd1", "asd1");
          System.out.println();
          conn.showBooks();
          
	}
}
