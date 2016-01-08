package pl.boguszg.impulse.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.boguszg.impulse.dao.UserDao;
import pl.boguszg.impulse.model.User;

@Service
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;				
	}
	
	@Override
	@Transactional
	public void addUser(User u) {
		this.userDao.updateUser(u);
		
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDao.addUser(u);
		
	}

	@Override
	@Transactional
	public List<User> listUser() {
		return this.userDao.listUser();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDao.removeUser(id);
	}
	


}
