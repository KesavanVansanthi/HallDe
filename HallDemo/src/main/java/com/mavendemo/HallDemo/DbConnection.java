package com.mavendemo.HallDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	public static void main(String[] args) {
			
			final String URL="jdbc:oracle:thin:@localhost:1521:xe";
			final String userName="SYSTEM";
			final String password="130602";
//			
//			//Queries
			int n=135;
			String name = "Nidhi";
//			final String QUERY_CREATE = "CREATE TABLE DATABASE.HALL_DEMO(HALLID NUMBER,OWNERNAME VARCHAR(20),HALLFLOORS NUMBER)";
//			final String QUERY_INSERT="INSERT INTO DATABASE.HALL_DEMO VALUES("+n+",'"+name+"',2)";
//			final String QUERY_DELETE="DELETE FROM DATABASE.HALL_DEMO WHERE OWNERNAME='Sathish'";
//			final String QUERY_UPDATE="UPDATE DATABASE.HALL_DEMO SET HALLFLOORS=1 WHERE HALLID=123";
			final String QUERY_INSERT="INSERT INTO DATABASE.HALL_DEMO VALUES("+n+",'"+name+"',2)";

			
			// 1.Regestering the driver class
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2.create connection
				Connection con=DriverManager.getConnection(URL,userName,password);
				
				if(con==null) {
					System.out.println("Connection Not Establised");			
				}
				else {
					System.out.println("Connection Established!!");
				}
				
				//step 3.Creating a Statement
				Statement stat = con.createStatement();
				
				//Step.4 Executing the Query
				boolean isCreated = stat.execute(QUERY_INSERT);
				
				if(isCreated) {
					System.out.println("Done!!!");
				}
				else {
					System.out.println("Not_Done!!!");
				}
				
				ResultSet result=stat.executeQuery("select * from DATABASE.Hall_demo");
				System.out.println("TESTID | TESTNAME | TESTSCORE");
				while(result.next())
					System.out.println(result.getInt(1)+"  | "+result.getString(2)+" | "+result.getString(3));

				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}

/*
 final String QUERY_INSERT="INSERT INTO DATABASE.TEST_CHECK VALUES (?,?,?)";
//		final String QUERY_DELETE="DELETE FROM DATABASE.TEST_CHECK WHERE TESTID=? ";
//		final String QUERY_UPDATE="UPDATE DATABASE.TEST_CHECK SET TESTSCORE=90 WHERE TESTNAME=? ";
		final String QUERY_INSERT="INSERT INTO DATABASE.CUSTOMER VALUES (?,?,?,?,?,?,?)";
//		final String QUERY_SELECT="SELECT * FROM DATABASE.test_check";
		//Step 1- Register the driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Step 2- Create connection 
			conn=DriverManager.getConnection(URL,userName,password);
			if(conn==null) {
				System.out.println("Db not yet connected!!");
			}else {
				System.out.println("Db connected successfully!!");
			}
			
			//Step 3- Preparing statements
//			int id=sc.nextInt();
			String sub=sc.next();
//			float score=sc.nextFloat();
			PreparedStatement sts=conn.prepareStatement(QUERY_INSERT);//dynamic - values can be changed based on user inputs
//			PreparedStatement sts=conn.prepareStatement(QUERY_DELETE);
//			PreparedStatement sts=conn.prepareStatement(QUERY_UPDATE);
//			PreparedStatement sts=conn.prepareStatement(QUERY_SELECT);
//			sts.setInt(1,id);
//			sts.setString(1, sub);
//			sts.setFloat(3, (float)score);
			 sts.setString(1, "SRI");
	            sts.setString(2, "PRASANNA");
	            sts.setString(3, "ASKJN");
	            sts.setLong(4, 345678);
	            sts.setInt(5, 21);
	            sts.setString(6, "GVSVS");
	            sts.setLong(7, 456789);
			
			//step 4- executing the query 
			int rowInserted=sts.executeUpdate();//returns integer values
			System.out.println(rowInserted);
			
			ResultSet result=sts.executeQuery();//returns resultset 
			System.out.println("TESTID | TESTNAME | TESTSCORE");
			while(result.next())
				System.out.println((result.getInt(1)+"  | "+result.getString(2)+" | "+result.getString(3)));
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
 */
