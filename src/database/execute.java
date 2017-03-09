package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class execute {
	public execute(){
		
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
