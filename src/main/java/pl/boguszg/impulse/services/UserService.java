package pl.boguszg.impulse.services;

import java.util.List;
import pl.boguszg.impulse.domain.User;

public interface UserService {
	
	public void insertData(User user);
	public List<User> getUserList();
	public void updateData(User user);
	public void deleteData(String id);
	public User getUser(String id);

}
