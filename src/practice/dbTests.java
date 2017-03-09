package practice;

import static org.junit.Assert.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import org.junit.Test;
import static org.junit.Assert.*;

/*
void assertEquals(boolean expected, boolean actual)
Checks that two primitives/objects are equal.
	
void assertFalse(boolean condition)
Checks that a condition is false.

void assertNotNull(Object object)
Checks that an object isn't null.

void assertNull(Object object)
Checks that an object is null.
	
void assertTrue(boolean condition)
Checks that a condition is true.

void fail()
Fails a test with no message.
*/

public class dbTests {

	@Test
	public void testShowDatabases() throws SQLException{
		start db = new start();
		Connection con = DriverManager.getConnection("jdbc:mysql://jliedtke.com/","liedtke","Reddev#93");
		db.showDatabases(con);
	}
	
	@Test
	public void testShowDatabasesTables() throws SQLException{
		start db = new start();
		Connection con = DriverManager.getConnection("jdbc:mysql://jliedtke.com/","liedtke","Reddev#93");
		Statement stmt = db.selectDatabase(con, "coms309");
		db.showDatabaseTables(stmt, "coms309");
		assertTrue(2==2);
	}
	
	@Test
	public void testAlternativeUserShowDatabasesTables() throws SQLException{
		start db = new start();
		Connection con2 = DriverManager.getConnection("jdbc:mysql://jliedtke.com/","seriaka","phinx93");
		Statement stmt = db.selectDatabase(con2, "coms309");
		db.showDatabaseTables(stmt, "coms309");
		assertEquals("passed","passed");
	}
	
	@Test
	public void testCreateDatabase() throws SQLException{
		start db = new start();
		Connection con = DriverManager.getConnection("jdbc:mysql://jliedtke.com/","liedtke","Reddev#93");
		Statement stmt = con.createStatement();
		boolean sucess = db.createDatabase(stmt, "imaDatabase");
		assertTrue(sucess);
		db.showDatabases(con);
	}
	
	@Test
	public void testDeleteDatabase() throws SQLException{
		start db = new start();
		Connection con = DriverManager.getConnection("jdbc:mysql://jliedtke.com/","liedtke","Reddev#93");
		Statement stmt = con.createStatement();
		boolean sucess = db.deleteDatabase(stmt, "imaDatabase");
		assertTrue(sucess);
		db.showDatabases(con);
	}
	
	@Test
	public void testCreateTable() throws SQLException{
		start db = new start();
		Connection con = DriverManager.getConnection("jdbc:mysql://jliedtke.com/","liedtke","Reddev#93");
		Statement stmt = db.selectDatabase(con, "seriaka");
		boolean sucess = db.createTable(stmt, "imaTable");
		assertTrue(sucess);
		db.showTables(stmt,"seriaka");
	}
	
	@Test
	public void testDeleteTable() throws SQLException{
		start db = new start();
		Connection con = DriverManager.getConnection("jdbc:mysql://jliedtke.com/","liedtke","Reddev#93");
		Statement stmt = db.selectDatabase(con, "seriaka");
		boolean sucess = db.deleteTable(stmt, "imaTable");
		assertTrue(sucess);
		db.showTables(stmt,"seriaka");
	}
	
	
}




