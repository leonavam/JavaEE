package edu.ucam.dao.mysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyConnectionSQL {

	private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost/dad2?serverTimezone=UTC&useSSL=false";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "";
	private static Driver driver = null;

	public static synchronized Connection getConection() throws SQLException {
		try {
			Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
			driver = (Driver) jdbcDriverClass.newInstance();
			DriverManager.registerDriver(driver);
		} catch (Exception e) {
			System.out.println("Fall&oacute al cargar el driver JDBC");
			e.printStackTrace();
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
