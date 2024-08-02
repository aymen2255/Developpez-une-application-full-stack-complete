package com.openclassrooms.mddapi.dtos.theme;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThemeResponseDTO {

	private Integer id;

	private String name;
	
	private String description;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "created_at")
	private Timestamp createdAt;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@JsonProperty(value = "updated_at")
	private Timestamp updatedAt;
}
