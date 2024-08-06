package com.openclassrooms.mddapi.controllers;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openclassrooms.mddapi.dtos.user.UserDTO;
import com.openclassrooms.mddapi.dtos.user.UserUpdateRequestDTO;
import com.openclassrooms.mddapi.dtos.user.UserUpdateResponseDTO;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.services.user.UserService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	private final ModelMapper modelMapper;

	@GetMapping("/me")
	public ResponseEntity<UserDTO> getCurrentUser() {
		User user = userService.getUser();
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return ResponseEntity.ok(userDTO);
	}

	@PostMapping("/me/update")
	public ResponseEntity<UserUpdateResponseDTO> updateUser(@Valid @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {

		String newJwt = userService.updateUser(userUpdateRequestDTO);

		UserUpdateResponseDTO token = UserUpdateResponseDTO.builder().token(newJwt).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(token);

	}
}
