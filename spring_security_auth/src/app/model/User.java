package app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {

	}

	@Id
	@Column(name = "id")
	private Long id;

	public Long getUserid() {
		return id;
	}

	public void setUserid(Long id) {
		this.id = id;
	}

	@Column(name = "username")
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

//	@OneToMany(mappedBy = "user")
//	private List<UserRole> userRoles;
	
	@OneToMany
    @JoinTable( 
        name = "user_role", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private List<UserRole> userRoles;

	/*
	 * @OneToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id")
	 * }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "role_id") }) private Set<Role> userRoles = new
	 * HashSet<Role>();
	 * 
	 * public Set<Role> getUserRoles() { return userRoles; }
	 * 
	 * public void setUserRoles(Set<Role> userRoles) { this.userRoles = userRoles; }
	 * 
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}