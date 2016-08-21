package eg.edu.alexu.csd.oop.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);

		DriverEngine x = new DriverEngine();
		Properties info = new Properties();

		Connection y = x.connect("jdbc:xmldb://localhost", info);
		Statement z = y.createStatement();
		z.execute("CREATE DATABASE TestDB_Select");
		System.out.println(
				z.execute("CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
		System.out.println(z.executeUpdate(
				"INSERT INTO table_name13(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));

	}

}
