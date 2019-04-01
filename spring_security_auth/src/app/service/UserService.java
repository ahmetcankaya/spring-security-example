package app.service;

import org.springframework.stereotype.Service;

import app.model.User;

@Service
public interface UserService {

	public User findUserByUsername(String username);

}