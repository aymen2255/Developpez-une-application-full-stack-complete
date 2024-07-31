package com.openclassrooms.mddapi.dtos.comment;

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
public class CommentResponseDTO {

	private Integer id;

	private String content;

	private UserDTO author;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "created_at")
	private String createdAt;

}
