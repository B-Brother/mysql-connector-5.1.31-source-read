package com.alibaba.tinker.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestBasicSelect {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		// 进入到mysql驱动包的入口在NonRegisteringDriver.connect(String url, Properties info)
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tinker", "root", "beckham");
		
		Statement stmt = conn.createStatement();
	
		ResultSet rs = stmt.executeQuery("SELECT * FROM REGISTER_INTERFACE");
		
		while(rs.next()){
			String appName = rs.getString("APP_NAME");
			
			String timeOut = rs.getString("TIMEOUT");
			
			System.out.println("appName:" + appName + ", timeOut=" + timeOut);
		}
	}
}
