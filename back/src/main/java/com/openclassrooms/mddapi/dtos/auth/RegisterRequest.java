package com.openclassrooms.mddapi.dtos.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	@NotEmpty
	@NotBlank(message = "Name is required")
	private String username;

	@NotEmpty
	@NotBlank(message = "Email is required")
	private String email;

	@NotEmpty
	@NotBlank(message = "password is required")
	private String password;

}