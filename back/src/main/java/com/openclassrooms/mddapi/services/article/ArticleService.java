package com.openclassrooms.mddapi.services.article;

import java.util.List;
import com.openclassrooms.mddapi.dtos.article.CreateArticleDTO;
import com.openclassrooms.mddapi.entities.Article;

public interface ArticleService {
	
	List<Article> getAllArticles();

	Article createArticle(CreateArticleDTO articleDTO, String email);
}
