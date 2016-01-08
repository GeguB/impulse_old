package pl.boguszg.impulse.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import pl.boguszg.impulse.model.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserExtractor userExtractor = new UserExtractor();
		return userExtractor.extractData(rs);
		
	}

}
