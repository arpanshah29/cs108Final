package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	static String account = "ccs108tianzhao"; // replace with your account 
	static String password = "aixoifah"; // replace with your password 
	static String server = "mysql-user.stanford.edu";
	static String database = "c_cs108_tianzhao"; // replace with your db
	
	private Connection con;
	/**
	 * This constructor sets up the connection
	 * 
	 */
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection ( "jdbc:mysql://" + server, account ,password);
			Statement stmt = con.createStatement();
			stmt.executeQuery("USE " + database);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
         e.printStackTrace();
		}
	}
	
	public Statement getStatement() {
		Statement stmt;
		try {
			stmt = con.createStatement();
			return stmt;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}