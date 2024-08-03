package com.openclassrooms.mddapi.controllers;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.openclassrooms.mddapi.dtos.response.MessageResponseDTO;
import com.openclassrooms.mddapi.dtos.theme.ThemeResponseDTO;
import com.openclassrooms.mddapi.dtos.theme.ThemesDTO;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.services.subscription.SubscriptionService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SubscriptionController {

	private final SubscriptionService subscriptionService;
	private final ModelMapper modelMapper;
	
	@GetMapping("/subscribed-themes")
	public ResponseEntity<ThemesDTO> getSubscribedThemes() {
		List<Theme> themes = subscriptionService.getSubscribedThemes();

		List<ThemeResponseDTO> listThemeDTO = new ArrayList<>(themes.size());

		for (Theme theme : themes) {
			ThemeResponseDTO themeDTO = modelMapper.map(theme, ThemeResponseDTO.class);
			listThemeDTO.add(themeDTO);
		}

		ThemesDTO themesDTO = new ThemesDTO();
		themesDTO.setThemes(listThemeDTO);

		return ResponseEntity.ok(themesDTO);
	}
	
	@PostMapping("/subscribe/{themeId}")
	public ResponseEntity<MessageResponseDTO> subscribeToTheme(@PathVariable Integer themeId) {
		
		subscriptionService.subscribeToTheme(themeId);

		MessageResponseDTO message = MessageResponseDTO.builder().message("Subscription is ok").build();

		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
}
