package app.dao;

import app.model.User;

public interface UserDao {

	User findUserByUsername(String username);
}