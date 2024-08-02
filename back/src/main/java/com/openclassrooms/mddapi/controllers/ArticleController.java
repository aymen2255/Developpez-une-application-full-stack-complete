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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openclassrooms.mddapi.dtos.article.ArticleResponseDTO;
import com.openclassrooms.mddapi.dtos.article.ArticlesDTO;
import com.openclassrooms.mddapi.dtos.article.ArticleRequestDTO;
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
	public ResponseEntity<ArticlesDTO> getAllArticles(Authentication authentication) {
		List<Article> articles = articleService.getSubscribedArticles(authentication.getName());

		List<ArticleResponseDTO> listArticleDTO = new ArrayList<>(articles.size());

		for (Article article : articles) {
			ArticleResponseDTO articleDTO = modelMapper.map(article, ArticleResponseDTO.class);
			listArticleDTO.add(articleDTO);
		}

		ArticlesDTO articlesDTO = new ArticlesDTO();
		articlesDTO.setArticles(listArticleDTO);

		return ResponseEntity.ok(articlesDTO);
	}

	@PostMapping("/article/create")
	public ResponseEntity<MessageResponseDTO> createArticle(@Valid @RequestBody ArticleRequestDTO articlelDTO, Authentication authentication) {

		articleService.createArticle(articlelDTO, authentication.getName());

		MessageResponseDTO message = MessageResponseDTO.builder().message("Article created !").build();

		return ResponseEntity.status(HttpStatus.CREATED).body(message);

	}
	
	@GetMapping("/article/{id}")
	public ResponseEntity<ArticleResponseDTO> getRentalById(@PathVariable Integer id) {

		Article article = articleService.getArticleById(id);
		ArticleResponseDTO articleDTO = modelMapper.map(article, ArticleResponseDTO.class);

		return ResponseEntity.ok(articleDTO);
	}
}
