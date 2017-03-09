package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	execute exe;
	public database(){
		exe = new execute();
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
		exe.myQuery(stmt,query);
		return stmt;
	}
}
