package JDBCµÚÈýÌâ;


/*********************??????????????????*******************************/
/*  ( 1 ) Import Java Classes                                         */
/**********************************************************************/

import java.sql.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class labupdate1 {
	static {
		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
		} catch (Exception e) {
			System.out.println("\n  Error loading DB2 Driver...\n");
			System.out.println(e);
			System.exit(1);
		}
	}

	public static void main(String args[]) throws Exception {
		String name = "";
		java.lang.String deptno = "";
		short id = 0;
		double salary = 0;
		String job = "";
		short NumEmp = 0;
		String sqlstmt = "UPDATE STAFF SET SALARY = SALARY * 1.05 WHERE DEPT = ?";
		String s = " ";
		int mydeptno = 0;
		int SQLCode = 0;
		String SQLState = "     ";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Connect statement follows:");

		Connection sample = DriverManager.getConnection("jdbc:db2:sample");

		System.out.println("Connect completed");

		sample.setAutoCommit(false);

		System.out.println("This program will update the salaries for a department");
		System.out.println("\n");
		System.out.println("Please enter a department number: \n ");
		s = in.readLine();
		deptno = s.substring(0, 2);
		mydeptno = Integer.parseInt(deptno);
		System.out.println("Statement stmt follows");
		try {
			PreparedStatement pUpd = sample.prepareStatement(sqlstmt);
			pUpd.setString(1, deptno);
			int updateCount = pUpd.executeUpdate();

			System.out.println("\nNumber of rows updated: " + updateCount);
		} // end try
		catch (SQLException x) {
			SQLCode = x.getErrorCode();
			SQLState = x.getSQLState();
			String Message = x.getMessage();
			System.out.println("\nSQLCODE:  " + SQLCode);
			System.out.println("\nSQLSTATE: " + SQLState);
			System.out.println("\nSQLERRM:  " + Message);
		}

		System.exit(0);
	} // end main

} // end of kegstaff class
