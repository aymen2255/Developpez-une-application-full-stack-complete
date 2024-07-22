package com.openclassrooms.mddapi.services.auth;

import com.openclassrooms.mddapi.dtos.auth.AuthentificationRequest;
import com.openclassrooms.mddapi.entities.User;

public interface AuthentificationService {
	User register(User user);

	String login(AuthentificationRequest authenticationRequest);
}
