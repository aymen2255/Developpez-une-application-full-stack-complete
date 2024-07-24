package com.openclassrooms.mddapi.controllers;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openclassrooms.mddapi.dtos.auth.AuthentificationRequest;
import com.openclassrooms.mddapi.dtos.auth.AuthentificationResponse;
import com.openclassrooms.mddapi.dtos.auth.RegisterRequest;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.services.auth.AuthentificationServiceImpl;
import com.openclassrooms.mddapi.util.JWTService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthentificationServiceImpl authService;
	private final JWTService jwtService;
	private final ModelMapper modelMapper;

	@PostMapping("/register")
	public ResponseEntity<AuthentificationResponse> register(@RequestBody @Valid RegisterRequest registerRequest) {

		User user = modelMapper.map(registerRequest, User.class);

		authService.register(user);

		String jwtToken = jwtService.generateToken(user);

		return ResponseEntity.ok(AuthentificationResponse.builder().token(jwtToken).build());

	}

	@PostMapping("/login")
	public ResponseEntity<AuthentificationResponse> login(@RequestBody @Valid AuthentificationRequest authentificationRequest) {

		String jwtToken = authService.login(authentificationRequest);

		return ResponseEntity.ok(AuthentificationResponse.builder().token(jwtToken).build());
	}
}
