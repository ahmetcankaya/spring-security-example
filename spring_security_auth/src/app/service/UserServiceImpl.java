package app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.UserDao;
import app.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findUserByUsername(final String username) {
		return userDao.findUserByUsername(username);
	}

}
