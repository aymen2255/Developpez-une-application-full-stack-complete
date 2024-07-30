package com.openclassrooms.mddapi.dtos.coment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.mddapi.dtos.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

	private Integer id;

	@NotBlank(message = "Message is required")
	@Size(max = 2000)
	private String content;

	@NotNull(message = "Author is required")
	private UserDTO author;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "created_at")
	private String createdAt;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "updated_at")
	private String updatedAt;
}
