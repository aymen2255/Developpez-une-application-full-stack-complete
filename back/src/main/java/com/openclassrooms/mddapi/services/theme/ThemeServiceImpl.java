package com.openclassrooms.mddapi.services.theme;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.dtos.theme.ThemeResponseDTO;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.services.subscription.SubscriptionService;
import com.openclassrooms.mddapi.services.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {

	private final ThemeRepository themeRepository;
	private final UserService userService;
	private final SubscriptionService subscriptionService;
	private final ModelMapper modelMapper;

	@Override
	public List<ThemeResponseDTO> getAllThemes() {

		User user = userService.getUser();

		List<Theme> themes = themeRepository.findAll();

		Set<Integer> subscribedThemeIds = subscriptionService.getSubscribedThemeIds(user.getId());

		List<ThemeResponseDTO> subscribedThemes = new ArrayList<>();

		for (Theme theme : themes) {
			ThemeResponseDTO themeResponseDTO = modelMapper.map(theme, ThemeResponseDTO.class);
			themeResponseDTO.setSubscribed(subscribedThemeIds.contains(theme.getId()));
			subscribedThemes.add(themeResponseDTO);
		}

		return subscribedThemes;
	}

	@Override
	public Theme getThemeById(Integer id) throws EntityNotFoundException {

		return themeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Theme Not found"));
	}

}
