package com.openclassrooms.mddapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dtos.theme.ThemeDTO;
import com.openclassrooms.mddapi.dtos.theme.ThemesDTO;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.services.theme.ThemeService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ThemeController {

	private final ThemeService themeService;
	private final ModelMapper modelMapper;

	@GetMapping("/themes")
	public ResponseEntity<ThemesDTO> getAllThemes() {
		List<Theme> themes = themeService.getAllThemes();

		List<ThemeDTO> listThemeDTO = new ArrayList<>(themes.size());

		for (Theme theme : themes) {
			ThemeDTO themeDTO = modelMapper.map(theme, ThemeDTO.class);
			listThemeDTO.add(themeDTO);
		}
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ThemesDTO themesDTO = new ThemesDTO();
		themesDTO.setThemes(listThemeDTO);

		return ResponseEntity.ok(themesDTO);
	}
}
