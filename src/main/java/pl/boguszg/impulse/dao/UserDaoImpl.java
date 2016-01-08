package pl.boguszg.impulse.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pl.boguszg.impulse.jdbc.UserRowMapper;
import pl.boguszg.impulse.model.User;

public class UserDaoImpl implements UserDao {

 @Autowired
 DataSource dataSource;

 public void insertData(User user) {

  String sql = "INSERT INTO user "
    + "(username, email, roles_role, password) VALUES (?, ?, ?, ?)";

  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

  jdbcTemplate.update(sql,
    new Object[] { user.getUsername(), user.getEmail(), user.getRole(), user.getPassword() });

 }


 public List<User> getUserList() {
  List<User> userList = new ArrayList<User>();

  String sql = "select * from users";

  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, new UserRowMapper());
  return userList;
 }

//@Override 
 public void deleteData(String id) {
  String sql = "delete from user where user_id=" + id;
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  jdbcTemplate.update(sql);

 }

 //@Override 
 public void updateData(User user){
	 
 }
 /*
 @Override
 public void updateData(User user) {

  String sql = "UPDATE user set username = ?, email = ?,  = ?, city = ? where user_id = ?";
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

  jdbcTemplate.update(
    sql,
    new Object[] { user.getUsername(), user.getLastName(),
      user.getGender(), user.getCity(), user.getUserId() });

 }
*/
 
 //@Override 
 public User getUser(String id) {
  List<User> userList = new ArrayList<User>();
  String sql = "select * from user where ID = " + id;
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, new UserRowMapper());
  return userList.get(0);
 }

}

