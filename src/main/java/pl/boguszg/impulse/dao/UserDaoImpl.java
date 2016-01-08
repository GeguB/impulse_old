package pl.boguszg.impulse.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Override
	public void addUser(User u) {
    	Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
        logger.info("User saved successfully, User Details="+u);
	}
    
    @Override
	public void updateUser(User u) {
    	Session session = this.sessionFactory.getCurrentSession();
    	session.update(u);
    	logger.info("User updated successfully, User Details="+u);
	}
	
	@SuppressWarnings("unchecked")
    @Override
	public List<User> listUser() {
		Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("from Users").list();
        for(User u : personsList){
            logger.info("Users List::"+u);
        }
        return personsList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
        User u = (User) session.load(User.class, new Integer(id));
        logger.info("User loaded successfully, User details="+u);
        return u;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));
        if(null != u){
            session.delete(u);
        }
        logger.info("User deleted successfully, user details="+u);		
	}


}

