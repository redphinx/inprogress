package practice;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class start {
	/*
	public static void main(String args[]){		
		Connection conn = null;
		System.out.println("connecting...");
		try {
			new start();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	*/
	
	/**
	 * general list of commands found at http://g2pc1.bu.edu/~qzpeng/manual/MySQL%20Commands.htm
	 */
	public start(){
		
	}
	
	/**
	 * Shows all databases within a given connection. May assume admin status.
	 * @param	con		Is the connection to a mysql server.
	 */
	public void showDatabases(Connection con) throws SQLException{
		ResultSet rs = con.getMetaData().getCatalogs();
		while (rs.next()) {
		    System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
		}
	}
	
	/**
	 * selects	database given a connection of an admin login.
	 * @param	con 		is direct connection to database
	 * @param 	database	is the name of database to connect to
	 * @return 	stmt		returns the current statement of the connection 			
	 */
	public Statement selectDatabase(Connection con,String database) throws SQLException{
		Statement stmt = con.createStatement();
		String query = "use "+ database+";";
		myQuery(stmt,query);
		return stmt;
	}
	
	/**
	 * Shows all tables in a given database. This function assumes a database is selected or in use.
	 * @param	stmt	is the current statement and located within a database
	 */
	public void showDatabaseTables(Statement stmt,String databaseName) throws SQLException{
		String query = "show tables;";
		ResultSet rs = myQuery(stmt,query);
		String location ="Tables_in_"+databaseName;
		while (rs.next()) {
		    System.out.println(location + " = " + rs.getString(location) );
		}
	}
	
	/**
	 * Shows all tables in a given database. This function assumes a database is selected or in use.
	 * @param	stmt	is the current statement and located within a database
	 */
	public void showTables(Statement stmt,String databaseName) throws SQLException{
		String query = "show tables;";
		ResultSet rs = myQuery(stmt,query);
		String location ="Tables_in_"+databaseName;
		while (rs.next()) {
		    System.out.println(location + " = " + rs.getString(location) );
		}
	}
	
	/**
	 * 
	 */
	public boolean createDatabase(Statement stmt, String dbName){
		String query = "create database " + dbName;
		int rs = myUpdateQuery(stmt,query);
		System.out.println(rs);
		if(rs==-1){
			return false;
		}
		return true;
	}
	
	public boolean deleteDatabase(Statement stmt, String dbName){
		String query = "drop database " + dbName;
		int rs = myUpdateQuery(stmt,query);
		System.out.println(rs);
		if(rs==-1){
			return false;
		}
		return true;
	}
	
	/**
	 * Creates a table in a database
	 * TODO 	Add two or one parameter that accounts for rows and columns in database.
	 * @param 	stmt		Is the current statement and located within a database.
	 * @param 	tableName	Is the name of the table to be created.
	 * @return
	 */
	public boolean createTable(Statement stmt, String tableName){
		String query = 	"create table " + tableName + "(personid int(50) not null auto_increment primary key,firstname varchar(35),middlename varchar(50),lastname varchar(50) default 'bato');";
		int rs = myUpdateQuery(stmt,query);
		System.out.println(rs);
		if(rs==-1){
			return false;
		}
		return true;
	}
	
	public boolean deleteTable(Statement stmt, String tableName){
		String query = 	"drop table " + tableName;
		int rs = myUpdateQuery(stmt,query);
		System.out.println(rs);
		if(rs==-1){
			return false;
		}
		return true;
	}
	
	/**
	 * mysql statement execution method. This method executes mysql commands given a query.  
	 * @param	stmt	Is the current statement and located within a database.
	 * @param	query	Is the command wanted to be executed at given statement.
	 * @return	rs		Returns the ResultSet of that given execution statement.
	 */
	public ResultSet myQuery(Statement stmt, String query){
		try{
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		}catch(Exception e){
			System.out.println("query failed");
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * mysql statement execution method. This method executes mysql commands given a query.  
	 * @param	stmt	Is the current statement and located within a database.
	 * @param	query	Is the command wanted to be executed at given statement.
	 * @return	rs		Returns the int of that given execution statement.
	 */
	public int myUpdateQuery(Statement stmt, String query){
		try{
			int rs = stmt.executeUpdate(query);
			return rs;
		}catch(Exception e){
			System.out.println("query failed");
			System.out.println(e);
			return -1;
		}
	}
}
