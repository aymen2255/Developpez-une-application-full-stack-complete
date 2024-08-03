package com.openclassrooms.mddapi.services.theme;

import java.util.List;

import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.dtos.theme.ThemeResponseDTO;
import com.openclassrooms.mddapi.entities.Theme;

public interface ThemeService {
	List<ThemeResponseDTO> getAllThemes();

	Theme getThemeById(Integer id) throws EntityNotFoundException;
}
