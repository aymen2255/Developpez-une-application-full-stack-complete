package com.openclassrooms.mddapi.dtos.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDTO {
	
	@NotNull
	@NotEmpty
	@NotBlank(message = "Email is required")
	private String email;
	
	@NotNull
	@NotEmpty
	@NotBlank(message = "Name is required")
    private String username;
}
