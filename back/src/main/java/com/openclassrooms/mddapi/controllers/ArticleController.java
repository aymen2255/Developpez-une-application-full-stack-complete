package com.openclassrooms.mddapi.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openclassrooms.mddapi.dtos.article.ArticleDTO;
import com.openclassrooms.mddapi.dtos.article.ArticlesDTO;
import com.openclassrooms.mddapi.dtos.article.CreateArticleDTO;
import com.openclassrooms.mddapi.dtos.response.MessageResponseDTO;
import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.services.article.ArticleService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;
	private final ModelMapper modelMapper;

	@GetMapping("/articles")
	public ResponseEntity<ArticlesDTO> getAllArticles() {
		List<Article> articles = articleService.getAllArticles();

		List<ArticleDTO> listArticleDTO = new ArrayList<>(articles.size());

		for (Article article : articles) {
			ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
			listArticleDTO.add(articleDTO);
		}

		ArticlesDTO articlesDTO = new ArticlesDTO();
		articlesDTO.setArticles(listArticleDTO);

		return ResponseEntity.ok(articlesDTO);
	}

	@PostMapping("/article/create")
	public ResponseEntity<MessageResponseDTO> createArticle(@Valid @ModelAttribute CreateArticleDTO articlelDTO, Authentication authentication) {

		articleService.createArticle(articlelDTO, authentication.getName());

		MessageResponseDTO message = MessageResponseDTO.builder().message("Article created !").build();

		return ResponseEntity.status(HttpStatus.CREATED).body(message);

	}
}
