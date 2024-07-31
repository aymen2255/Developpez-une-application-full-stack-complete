package com.openclassrooms.mddapi.controllers;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openclassrooms.mddapi.dtos.comment.CommentRequestDTO;
import com.openclassrooms.mddapi.dtos.response.MessageResponseDTO;
import com.openclassrooms.mddapi.services.comment.CommentService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

	
	private final CommentService commentService;

	@PostMapping("/comment/add/{articleId}")
	public ResponseEntity<MessageResponseDTO> addComment(
			@PathVariable Integer articleId,
			@Valid @RequestBody CommentRequestDTO commentRequestDTO, 
			Authentication authentication
			) 
	{

		commentService.addComment(articleId, commentRequestDTO, authentication.getName());

		MessageResponseDTO message = MessageResponseDTO.builder().message("Comment added !").build();

		return ResponseEntity.status(HttpStatus.CREATED).body(message);

	}

}
