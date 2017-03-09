package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import Main;
public class table {
	execute exe;
	
	/**
	 * everything table related
	 */
	public table(){
		exe = new execute();
	}
	
	/**
	 * Shows all tables in a given database. This function assumes a database is selected or in use.
	 * @param	stmt	is the current statement and located within a database
	 */
	public void showDatabaseTables(Statement stmt,String databaseName) throws SQLException{
		String query = "show tables;";
		ResultSet rs = exe.myQuery(stmt,query);
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
		ResultSet rs = exe.myQuery(stmt,query);
		String location ="Tables_in_"+databaseName;
		while (rs.next()) {
		    System.out.println(location + " = " + rs.getString(location) );
		}
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
		int rs = exe.myUpdateQuery(stmt,query);
		System.out.println(rs);
		if(rs==-1){
			return false;
		}
		return true;
	}
	
	public boolean deleteTable(Statement stmt, String tableName){
		String query = 	"drop table " + tableName;
		int rs = exe.myUpdateQuery(stmt,query);
		System.out.println(rs);
		if(rs==-1){
			return false;
		}
		return true;
	}
}
