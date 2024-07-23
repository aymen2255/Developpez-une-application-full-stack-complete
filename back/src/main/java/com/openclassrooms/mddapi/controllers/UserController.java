package com.openclassrooms.mddapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dtos.user.UserDTO;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.services.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	private final ModelMapper modelMapper;

	@GetMapping("/me")
	public ResponseEntity<UserDTO> getProfile(@RequestHeader("Authorization") String authorization) {

		User user = userService.getUser();

		UserDTO userDTO = modelMapper.map(user, UserDTO.class);

		return ResponseEntity.ok(userDTO);
	}
}
