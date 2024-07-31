package com.openclassrooms.mddapi.dtos.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {

	@NotBlank(message = "Message is required")
	@Size(max = 2000)
	private String content;
}
