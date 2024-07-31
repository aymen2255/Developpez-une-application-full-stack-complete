package com.openclassrooms.mddapi.dtos.article;

import java.sql.Timestamp;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.mddapi.dtos.comment.CommentResponseDTO;
import com.openclassrooms.mddapi.dtos.theme.ThemeResponseDTO;
import com.openclassrooms.mddapi.dtos.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponseDTO {

	private Integer id;

	private String title;

	private String content;

	private UserDTO author;
	
	private ThemeResponseDTO theme;

	private List<CommentResponseDTO> comments;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "created_at")
	private Timestamp createdAt;

}
