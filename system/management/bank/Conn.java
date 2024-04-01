package system.management.bank;

import java.sql.*;


public class Conn{

	Connection c;
	Statement s;
	Conn()
	{
		// For building connection with database
		try{
		//	replace database name, username and password with your actual database name username and password.
			 c = DriverManager.getConnection("jdbc:mysql:///DatabaseName","username","Password");
			 s = c.createStatement();
			
		
		}catch (Exception e) {
		System.out.print(e);
	}
		
	}
}
