package com.openclassrooms.mddapi.dtos.article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateArticleDTO {
	
	@NotNull
	@NotEmpty
	@NotBlank(message = "Title is required")
	@Size(min = 3, message = "Title should have at least 3 characters")	
	private String title;
		
    @NotNull
	private String content;
    
    @NotNull(message = "Theme is required")
    private Integer themeId;
}
