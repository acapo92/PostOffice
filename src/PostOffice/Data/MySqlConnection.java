package PostOffice.Data;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

	private static Connection connection = null;

	private static Connection createConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/postoffice", "root", "");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return con;
	}

	public static Connection getConnection() {
		if (connection == null) {
			connection = createConnection();
		}
		return connection;

	}

}
