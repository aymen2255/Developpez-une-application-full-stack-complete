package com.openclassrooms.mddapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.openclassrooms.mddapi.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	@Query(value = "SELECT a.* FROM articles a JOIN subscriptions s ON a.theme_id = s.theme_id WHERE s.user_id = :userId", nativeQuery = true)
	List<Article> getSubscribedArticles(@Param("userId") Integer userId);
}
