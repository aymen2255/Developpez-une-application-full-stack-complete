package com.openclassrooms.mddapi.dtos.article;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.mddapi.dtos.coment.CommentDto;
import com.openclassrooms.mddapi.dtos.user.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

	private Integer id;

	@NotBlank(message = "Title is required")
	@Size(max = 50)
	private String title;

	@NotBlank(message = "Content is required")
	@Size(max = 2000)
	private String content;

	@NotEmpty
	@NotNull(message = "Author is required")
	private UserDTO author;

	private List<CommentDto> comments;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "created_at")
	private Timestamp createdAt;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "updated_at")
	private Timestamp updatedAt;
}
