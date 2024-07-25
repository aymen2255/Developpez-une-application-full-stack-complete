package com.openclassrooms.mddapi.services.article;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.repositories.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

	private final ArticleRepository articleRepository;

	@Override
	public List<Article> getAllArticles() {
		
		return articleRepository.findAll();
	}

}
