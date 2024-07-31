package com.openclassrooms.mddapi.services.article;

import java.util.List;

import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.dtos.article.ArticleRequestDTO;
import com.openclassrooms.mddapi.entities.Article;

public interface ArticleService {

	List<Article> getSubscribedArticles(String email);

	Article createArticle(ArticleRequestDTO articleDTO, String email);

	Article getArticleById(Integer id) throws EntityNotFoundException;
}
