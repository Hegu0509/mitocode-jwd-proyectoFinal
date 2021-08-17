package com.mitocode.securityconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.entities.Cuenta;
import com.mitocode.entities.Rol;
import com.mitocode.repository.UserRepository;





@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Cuenta user = userRepository.findByUserName(userName);
		
		if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (Rol role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		return new User(user.getUserName(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

}