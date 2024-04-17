package com.Blog_App.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Blog_App.models.User;
import com.Blog_App.repository.UserRepository;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
        		.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority autho=new SimpleGrantedAuthority("ROLE_"+user.getRoles().toUpperCase());
        authorities.add(autho);
            

        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                user.getPassword(),
                authorities
        );
    }
}