package com.openclassrooms.mddapi.services.theme;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.repositories.ThemeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {

	private final ThemeRepository themeRepository;

	@Override
	public List<Theme> getAllThemes() {

		return themeRepository.findAll();
	}

}
