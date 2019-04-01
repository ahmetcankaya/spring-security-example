package app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.UserDaoImpl;
import app.model.UserRole;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
	static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public UserDetailsServiceImp() {
	}

	@Autowired
	private UserService userService;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User securityUser = null;
		try {
			app.model.User user = userService.findUserByUsername(username);
			securityUser = new User(user.getUsername(), user.getPassword(), true, true, true, true,
					buildUserAuthority(user.getUserRoles()));
		} catch (Exception e) {
			logger.debug("Log4j error : " + e.getMessage());
		}
		return securityUser;
	}

	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {
		List<GrantedAuthority> results = null;
		try {
			Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

			for (UserRole userRole : userRoles) {
				setAuths.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
			}

			results = new ArrayList<GrantedAuthority>(setAuths);
		} catch (Exception e) {
			logger.debug("Log4j error : " + e.getMessage());
		}
		return results;
	}

}