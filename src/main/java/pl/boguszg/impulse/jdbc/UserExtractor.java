package pl.boguszg.impulse.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import pl.boguszg.impulse.model.User;

public class UserExtractor implements ResultSetExtractor<User> {

	public User extractData(ResultSet rs) throws SQLException, DataAccessException {

		User user = new User();
		
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		
		/*
		user.setEmail(rs.getString(3));
		user.setAccount(rs.getDouble(4));
		user.setEnabled(rs.getInt(5));
		user.setRole(rs.getString(6));
		*/
		
		return user;
	}
	

}
