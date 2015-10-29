package com.vzw.prepaid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestProcedure {

	public static void main(String args[]) {
		Connection conn = null;
		  String url = "jdbc:mysql://113.128.162.200:3306/";
		  String dbName = "world";
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = "dinesh"; 
		  String password = "dinesh";
		  try {
		  Class.forName(driver).newInstance();
		  conn = DriverManager.getConnection(url+dbName,userName,password);
		  CallableStatement cs = null;
		  cs = conn.prepareCall("{call CITY_PKQ()}");
	      boolean hasResultSet =  cs.execute();
	      if( hasResultSet ){
	            ResultSet rs = cs.getResultSet();
	            while (rs.next()) {
	                int id = rs.getInt(1);
	                String name = rs.getString(2);
	                String countryCOde = rs.getString(3);
	                String district = rs.getString(4);
	                int population = rs.getInt(5);
	                System.out.println(id + " " + name + " " + countryCOde + " " + district + " " + population);
	            }
	            
	      }
		  System.out.println("Connected to the database");
		  conn.close();
		  System.out.println("Disconnected from database");
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
		
	}
}
