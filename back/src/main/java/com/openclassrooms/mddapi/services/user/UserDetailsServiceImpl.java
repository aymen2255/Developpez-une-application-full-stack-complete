package com.openclassrooms.mddapi.services.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserDetails user = (UserDetails) userRepository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException("User not found"));
		return user;
	}

}
