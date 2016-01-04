package pl.boguszg.impulse;

import pl.boguszg.impulse.User;

public interface UserDAO {
	
	public void create (User user);
	public User findByEnabled(int enabled);

}
