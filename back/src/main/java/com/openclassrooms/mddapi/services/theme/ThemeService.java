package com.openclassrooms.mddapi.services.theme;

import java.util.List;

import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.entities.Theme;

public interface ThemeService {
	List<Theme> getAllThemes();

	Theme getThemeById(Integer id) throws EntityNotFoundException;
}
