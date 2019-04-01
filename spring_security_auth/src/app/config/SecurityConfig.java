package app.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan("com.app")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//		.antMatchers("/private/**")
//		.hasAnyAuthority("USER","ADMIN")
//		.antMatchers("/login","/public/restapi/**","/public/restapi/updateVeteriner")
		.antMatchers("/**")
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/main")
		.failureUrl("/login-status-error")
		.permitAll()
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout()
		.logoutSuccessUrl("/logout-success")
		.invalidateHttpSession(true).permitAll()
		.and().csrf().disable();
	}


	@Autowired
	protected void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		// auth.authenticationProvider(authenticationProvider());
	}

}