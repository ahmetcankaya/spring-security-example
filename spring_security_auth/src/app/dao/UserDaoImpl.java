package app.dao;

import app.model.User;
import app.dao.UserDao;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserByUsername(String username) {
		User user = null;
		try {
			// user = sessionFactory.getCurrentSession().get(User.class, username);
			String sql = "SELECT u FROM User u WHERE u.username=:prm";
			Query<User> q = sessionFactory.getCurrentSession().createQuery(sql, User.class);
			q.setParameter("prm", username);
			return q.getSingleResult();
		} catch (Exception e) {
			user = null;
			System.out.println("Error: " + e.getMessage());
			logger.debug("Log4j error : " + e.getMessage());
		}
		return user;
	}

}