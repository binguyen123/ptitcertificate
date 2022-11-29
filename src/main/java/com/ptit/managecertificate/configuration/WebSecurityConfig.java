package com.ptit.managecertificate.configuration;

import com.ptit.managecertificate.service.Impl.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("com.ptit.managecertificate")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomerUserDetailsService myUserDetailsService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers( "/login", "/logout","/resources/**","/contact")
				.permitAll();

		// Trang chỉ dành cho User
		http.authorizeRequests()
				.antMatchers()
				.hasAuthority("ROLE_USER");

		// Trang chỉ dành cho ADMIN
	    http.authorizeRequests()
				.antMatchers("/user/**","/certificate/**")
				.permitAll();

		// Khi người dùng đã login, với vai trò XX.
	    // Nhưng truy cập vào trang yêu cầu vai trò YY,
	    // Ngoại lệ AccessDeniedException sẽ ném ra.
	    http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
      
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login?error=false")//
                .defaultSuccessUrl("/")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}