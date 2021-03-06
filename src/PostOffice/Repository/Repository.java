package PostOffice.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Repository {

	protected Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/postoffice", "root", "");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return connection;
	}
}
