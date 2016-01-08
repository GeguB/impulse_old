package pl.boguszg.impulse.services;

import java.util.List;

import pl.boguszg.impulse.model.User;


public interface UserService {
	
	 public void addUser(User u);
	 public void updateUser(User u);
	 public List<User> listUser();
	 public User getUserById(int id);
	 public void removeUser(int id);

}
