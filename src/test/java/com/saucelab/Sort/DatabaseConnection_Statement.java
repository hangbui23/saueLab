package com.saucelab.Sort;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilitiesConfig.MySQLConnUtils;

public class DatabaseConnection_Statement {

	public static void main(String[] args) throws SQLException {
		Connection conn=MySQLConnUtils.getMySQLConnection();
		String sql = "select * from branch";
		Statement statement = conn.createStatement();
		ResultSet result= statement.executeQuery(sql);
		while(result.next()) {
			System.out.println(result.getString("ADDRESS"));
		}
	}

}
