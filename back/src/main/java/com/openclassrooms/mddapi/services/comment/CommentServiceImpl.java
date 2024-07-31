package com.openclassrooms.mddapi.services.comment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.dtos.comment.CommentRequestDTO;
import com.openclassrooms.mddapi.entities.Article;
import com.openclassrooms.mddapi.entities.Comment;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final UserRepository userRepository;
	private final ArticleRepository articleRepository;
	private final ModelMapper modelMapper;
	private final CommentRepository commentRepository;

	@Override
	public Comment addComment(Integer articleId, CommentRequestDTO commentRequestDTO, String email) {

		User author = userRepository.findByEmail(email);
		if (author == null) {
			throw new EntityNotFoundException("Author not found");
		}

		Article article = articleRepository.findById(articleId)
				.orElseThrow(() -> new EntityNotFoundException("Article not found"));

		Comment comment = this.modelMapper.map(commentRequestDTO, Comment.class);
		comment.setArticle(article);
		comment.setAuthor(author);

		return commentRepository.save(comment);
	}

}
