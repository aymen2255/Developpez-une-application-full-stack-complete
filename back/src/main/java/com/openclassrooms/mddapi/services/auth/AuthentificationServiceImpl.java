package com.openclassrooms.mddapi.services.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.openclassrooms.mddapi.Exception.UserAlreadyExistsException;
import com.openclassrooms.mddapi.dtos.auth.AuthentificationRequest;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.util.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImpl implements AuthentificationService {

	private final UserRepository userRepository;

	private final JWTService jwtService;

	private final AuthenticationManager authenticationManager;
	
	private final PasswordEncoder passwordEncoder;

	/**
	 * Registers a new user
	 */
	@Override
	public User register(User user) {

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException("User already exists.");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);

	}

	/**
	 * Authenticates a user and returns an authentication response with a JWT token.
	 *
	 * @param authenticationRequest The authentication request containing the user's
	 *                              email and password.
	 * @return String JWT token.
	 * @throws BadCredentialsException If authentication fails due to invalid
	 *                                 credentials.
	 */
	@Override
	public String login(AuthentificationRequest authenticationRequest) {
		try {
			// Authenticate the user using the email and password
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmail(), authenticationRequest.getPassword()));

			User user = userRepository.findByEmail(authenticationRequest.getEmail());

			return jwtService.generateToken(user);

		} catch (BadCredentialsException e) {

			throw new BadCredentialsException("Invalid username or passwordg");
		}
	}

}
