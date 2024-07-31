package com.openclassrooms.mddapi.dtos.article;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesDTO {
	private List<ArticleResponseDTO> articles;
}
