package com.openclassrooms.mddapi.services.theme;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
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

	@Override
	public Theme getThemeById(Integer id) throws EntityNotFoundException {

		return themeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theme Not found"));
	}

}
