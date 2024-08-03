package com.openclassrooms.mddapi.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openclassrooms.mddapi.dtos.theme.ThemeResponseDTO;
import com.openclassrooms.mddapi.dtos.theme.ThemesDTO;
import com.openclassrooms.mddapi.services.theme.ThemeService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ThemeController {

	private final ThemeService themeService;

	@GetMapping("/themes")
	public ResponseEntity<ThemesDTO> getAllThemes() {
		List<ThemeResponseDTO> themeResponseDTO = themeService.getAllThemes();

		return ResponseEntity.ok(new ThemesDTO(themeResponseDTO));
	}
}
