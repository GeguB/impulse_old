package pl.boguszg.impulse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.boguszg.impulse.dao.UserDao;
import pl.boguszg.impulse.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	public void insertData(User user) {
		userDao.insertData(user);		
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}

	public void updateData(User user) {
		userDao.updateData(user);		
	}

	public void deleteData(String id) {
		userDao.deleteData(id);		
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}

}
