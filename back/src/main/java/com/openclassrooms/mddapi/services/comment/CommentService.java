package com.openclassrooms.mddapi.services.comment;

import com.openclassrooms.mddapi.dtos.comment.CommentRequestDTO;
import com.openclassrooms.mddapi.entities.Comment;

public interface CommentService {
	Comment addComment(Integer articleId, CommentRequestDTO commentRequestDTO, String email);
}
