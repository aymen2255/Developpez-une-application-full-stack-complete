package com.openclassrooms.mddapi.services.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.dtos.user.UserUpdateRequestDTO;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.util.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final JWTService jwtService;

	@Override
	public User getUser() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User user = userRepository.findByEmail(userDetails.getUsername());

		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}

		return user;
	}

	@Override
	public String updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {

		User user = getUser();

		user.setEmail(userUpdateRequestDTO.getEmail());
		user.setUsername(userUpdateRequestDTO.getUsername());

		userRepository.save(user);

		return jwtService.generateToken(user);

	}

}
