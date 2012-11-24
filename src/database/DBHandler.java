package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * DBHandler should be only called once 
 * @author tianzhao
 *
 */
public class DBHandler {
	private Statement stmt;
	String username1 = "tianz";
	String username2 = "hungj";
	String username3 = "arpans";
	/**
	 * Create a handler object that handles the dbconnection.
	 * @param stmt
	 */
	public DBHandler() {
		DBConnection con = new DBConnection();
		this.stmt = con.getStatement();
		// createTables
		createTables();
	}
	
	/**
	 * Create all the tables
	 */
	private void createTables() {
		createUserTable();
		int quizId = 1;
		createQuizTable(username1,quizId);
		createQuizTable(username2,quizId+1);
	}
	
	
	/**
	 * Create a user table
	 */
	private void createUserTable() {
		String createUser = "create table if not exists userTable ("+"userId BIGINT," 
																	  	+ "userName CHAR(64),"
																	  	+ "password CHAR(64),"
																	  	+ "quizScore BIGINT"
																		+ ");";
		System.out.println(createUser);
		try {
			stmt.executeUpdate(createUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create a quiz table based on the given username and the quizId
	 * @param username Username
	 * @param quizId quizId
	 */
	private void createQuizTable(String username, int quizId) {
		String createQuiz = "create table if not exists quizTable_"+username+"_"+quizId+ " (" + "creatorId BIGINT,"
															+ "quizId BIGINT,"
															+ "quizName CHAR(64)," 
															+ "description CHAR(64),"
															+ "isPracticeMode INT default 0," // 1 = true, 0 = false
															+ "isRandom INT default 0," // 1 = ture, 0 = false
															+ "isOnePage INT default 0," // 1 = ture, 0 = false
															+ "isQuickResponse INT default 0," // 1 = ture, 0 = false
															+ "creationDate CHAR(64)" 
															+ ");";
		System.out.println(createQuiz);
		try {
			stmt.executeUpdate(createQuiz);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	private void createQuestionTable()
	
	
	
	
	
	public static void main(String[] args) {
		DBHandler dbhand  =new DBHandler();
	}
}
