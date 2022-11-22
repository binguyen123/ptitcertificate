package com.ptit.managecertificate.service.Impl;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ptit.managecertificate.entity.Role;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.service.UserService;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = Logger.getLogger(CustomerUserDetailsService.class);
	
    @Autowired
    private UserService userService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	User user = userService.getUserByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        
        List<Role> list = new ArrayList<Role>(user.getRoles());
        // [USER,ADMIN,..]
        
        
        logger.info("USER LOGIN ===============>"+user.getUsername());
        logger.info("PASSWORD ===============>"+user.getPassword());
        logger.info("ROLE ===============>"+list.get(0).getName());
        
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(list.get(0).getName());
        grantList.add(authority);
        
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails
        		.User(user.getUsername(),user.getPassword(),grantList);
 
        return userDetails;
    }
     
}