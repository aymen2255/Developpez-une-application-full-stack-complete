package com.openclassrooms.mddapi.services.article;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.dtos.article.ArticleRequestDTO;
import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.theme.ThemeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

	private final ArticleRepository articleRepository;
	private final UserRepository userRepository;
	private final ThemeService themeService;
	private final ModelMapper modelMapper;

	@Override
	public List<Article> getSubscribedArticles(String email) {

		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return articleRepository.getSubscribedArticles(user.getId());
	}

	@Override
	public Article createArticle(ArticleRequestDTO articleDTO, String email) {

		User author = userRepository.findByEmail(email);
		if (author == null) {
			throw new EntityNotFoundException("Author not found");
		}

		Theme theme = themeService.getThemeById(articleDTO.getThemeId());
		if (theme == null) {
			throw new EntityNotFoundException("Theme not found");
		}

		Article article = modelMapper.map(articleDTO, Article.class);
		article.setAuthor(author);
		article.setTheme(theme);

		return articleRepository.save(article);

	}

	@Override
	public Article getArticleById(Integer id) throws EntityNotFoundException {

		return articleRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Article Not found"));
	}

}
