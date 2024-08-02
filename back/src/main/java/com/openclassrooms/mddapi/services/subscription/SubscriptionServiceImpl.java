package com.openclassrooms.mddapi.services.subscription;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.entities.Subscription;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;
import com.openclassrooms.mddapi.repositories.SubscriptionRepository;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.services.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

	private final SubscriptionRepository subscriptionRepository;
	private final UserService userService;
	private final ThemeRepository themeRepository;

	@Override
	public List<Theme> getSubscribedThemes() {
		User user = userService.getUser();
		List<Subscription> subscriptions = subscriptionRepository.findByUserId(user.getId());
		
		List<Integer> themeIds = subscriptions.stream()
                .map(subscription -> subscription.getTheme().getId())
                .collect(Collectors.toList());

		 return themeRepository.findAllById(themeIds);
	}
}
