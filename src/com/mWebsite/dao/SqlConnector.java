/**
 * 
 */
package com.mWebsite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mWebsite.bean.Article;
import com.mWebsite.bean.Contact;
import com.mWebsite.util.QueryFactory;


/**
 * @author lxynox
 *
 */
class SqlConnector {

   private static SqlConnector instance = null;
//	 JDBC driver name and database URL
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private static final String DB_URL = "jdbc:mysql://localhost/mDatabase?";
   
//   JDBC Credentials
	private static final String USER_NAME = "root";  
	private static final String PASSWORD = "lxyWPI920817";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlConnector dbConnector = SqlConnector.getInstance();
		String getAllContactQuery = QueryFactory.getAllContact();
		List<Map<String, ?>> resultList = dbConnector.readFromDB (getAllContactQuery);
		
		System.out.println (resultList);
		System.out.println (resultList.get(0).get("name"));
		
		int id = (int) resultList.get(0).get("id");
		System.out.println (id);
		Timestamp timestamp = (Timestamp)resultList.get(1).get("time");
		System.out.println (timestamp);
	}
//	Reader
	public List<Map<String, ?>> getAllContactStringContainer() {
		String getAllContactQuery = QueryFactory.getAllContact();
		return readFromDB (getAllContactQuery);
	}
	public List<Map<String, ?>> getContactStringContainer(int id) {
		String getContactQuery = QueryFactory.getContact(id);
		return readFromDB (getContactQuery);
	}
	public List<Map<String, ?>> getAllArticleStringContainer() {
		String getAllArticleQuery = QueryFactory.getAllArticle();
		return readFromDB (getAllArticleQuery);
	}
//	Writer
	public String insertContact (Contact contact) {
		String insertContactQuery = QueryFactory.addContact(contact);
		return writeToDB (insertContactQuery); 
	}
	public String insertArticle (Article article) {
		String insertArticleQuery = QueryFactory.addArticle(article);
		return writeToDB (insertArticleQuery); 
	}
//	prevent initialization 
	protected SqlConnector() {
		System.out.println ("access to protected constructor from subclass!");
		// prevent from instantiation from other classes exclude inheritance && same package
	}
//	only access to the singleton
	public static SqlConnector getInstance() {
		if (instance == null) {
			instance = new SqlConnector();
			System.out.println (" initialization finished!");
		} else System.out.println ("instance is already created!");
		
		return instance;
	}
//	write to db
	protected String writeToDB (String query) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);
		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      stmt.executeUpdate(query);
		      System.out.println("Inserted records into the table...");
		   } catch (SQLException se) {
		      //Handle errors for JDBC
		      se.printStackTrace();
		   } catch (Exception e) {
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   } 
		   finally {
		      //finally block used to close resources
		      try {
		         if(stmt!=null)
		            conn.close();
		      } catch (SQLException se) {
		      }// do nothing
		      try {
		         if(conn!=null)
		            conn.close();
		      } catch (SQLException se) {
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		   String responseCode = new String();
		   return responseCode;
	}
	
// read from db
	protected List<Map<String, ?>> readFromDB(String query) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		List<Map<String, ?>> resultList = new ArrayList<Map<String, ?>>();
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);    
			// Do something with the Connection
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			// Now do something with the ResultSet ....
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNumber = rsmd.getColumnCount();
			System.out.println(columnNumber);
			
			for(int i=1; i <= columnNumber; i++) {
				System.out.print(rsmd.getColumnLabel(i)+ (i < columnNumber?" ":"\n"));
			}
			
			while (rs.next()) {
				Map<String, Object> rowMap = new HashMap<String, Object>();
				for(int i=1; i<= columnNumber; i++) {
					//System.out.print(rs.getString(i)+(i<columnNumber? " ":"\n"));
					rowMap.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				resultList.add(rowMap);
				//System.out.println();
			}
			if(rs.isClosed()) {
				System.out.println("the cursor is now closed");
			}else {
				System.out.println("sorry, not yet!");
				rs.close();
			}
			// return resultList;
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
//	it is a good idea to release resources in a finally{} block in reverse-order of their creation
//				 if they are no-longer needed
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) { } // ignore
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) { } // ignore
				stmt = null;
			}
		}
		return resultList;
	}
	
}
