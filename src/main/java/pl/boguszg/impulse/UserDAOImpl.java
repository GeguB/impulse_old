package pl.boguszg.impulse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import pl.boguszg.impulse.User;
import pl.boguszg.impulse.UserDAO;

public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(User user) {

		String sql = "INSERT INTO 'impulse'.'users' (username, enabled) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setInt(2, user.getEnabled());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public User findByEnabled(int enabled) {
		String sql = "SELECT * FROM 'impulse'.'users' WHERE enabled = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, enabled);
			User user = null; 
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				user = new User(
						rs.getString("user")					
						);
			}
			rs.close();
			ps.close();
			return user;		
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		} 
	}


}
