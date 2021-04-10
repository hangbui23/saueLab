package com.saucelab.Sort;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilitiesConfig.MySQLConnUtils;

public class DatabaseConnection_PreStatement {

	public static void main(String[] args) throws SQLException {
		Connection conn=MySQLConnUtils.getMySQLConnection();
		String sql = "select first_name,last_name from employee where title like ? and dept_id =?";
		PreparedStatement prestatement = conn.prepareStatement(sql);
		prestatement.setString(1, "Teller%");
		prestatement.setInt(2, 1);
		ResultSet result= prestatement.executeQuery();
		while(result.next()) {
			System.out.println("First Name" + " " + result.getString("FIRST_NAME") + " " + "Last Name" + " " + result.getString("LAST_NAME"));
		}
	}

}
