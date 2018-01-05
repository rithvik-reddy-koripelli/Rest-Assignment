package com.accolite.mini_au.Rest_Assignment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.api.jdbc.Statement;



public class MyConnection {
	Connection con ;
	Statement stmt;
	private static MyConnection connection;
	
	private MyConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/au","root","root");
			stmt=(Statement) con.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static MyConnection  getConnection()
	{
		if(connection==null)
		{	synchronized (MyConnection.class) {
				if(connection == null)
				{
					connection =  new MyConnection();
				}
			}
		}
		return connection;
	}
}
