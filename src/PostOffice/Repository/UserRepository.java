package PostOffice.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PostOffice.Entity.User;

public class UserRepository extends Repository {

	public User findByUsernameAndPassword(String username, String password) throws SQLException {

		Connection con = null;
		PreparedStatement pstm = null;
		User user = null;
		ResultSet rs = null;
		try {
			con = getConnection();

			pstm = con.prepareStatement("SELECT * FROM `users` WHERE `username`=? AND `password`=? LIMIT 1");
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.execute();
			rs = pstm.getResultSet();

			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}

		con.close();

		return user;
	}

}
