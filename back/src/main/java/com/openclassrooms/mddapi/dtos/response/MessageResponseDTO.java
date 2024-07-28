package com.openclassrooms.mddapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
public class MessageResponseDTO {
	private String message;
}
