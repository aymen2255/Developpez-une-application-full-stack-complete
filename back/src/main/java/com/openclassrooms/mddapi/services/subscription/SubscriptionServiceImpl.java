package com.openclassrooms.mddapi.services.subscription;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.openclassrooms.mddapi.Exception.EntityNotFoundException;
import com.openclassrooms.mddapi.Exception.SubscriptionAlreadyExistsException;
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

		List<Integer> themeIds = subscriptions.stream().map(subscription -> subscription.getTheme().getId())
				.collect(Collectors.toList());

		return themeRepository.findAllById(themeIds);
	}

	@Override
	public Subscription subscribeToTheme(Integer themeId) {

		User user = userService.getUser();

		Theme theme = themeRepository.findById(themeId)
				.orElseThrow(() -> new EntityNotFoundException("Theme not found"));

		Subscription subscription = subscriptionRepository.findOneByThemeAndUser(theme, user);

		if (subscription != null) {
			throw new SubscriptionAlreadyExistsException("Already subscribed");
		}

		Subscription newSubscription = new Subscription();
		newSubscription.setTheme(theme);
		newSubscription.setUser(user);

		return subscriptionRepository.save(newSubscription);

	}

	public Set<Integer> getSubscribedThemeIds(Integer userId) {

		List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);
		return subscriptions.stream().map(subscription -> subscription.getTheme().getId()).collect(Collectors.toSet());
	}

	@Override
	public void unsubscribeUserFromTheme(Integer themeId) {

		User user = userService.getUser();

		Theme theme = themeRepository.findById(themeId)
				.orElseThrow(() -> new EntityNotFoundException("Theme not found"));

		Subscription subscription = subscriptionRepository.findOneByThemeAndUser(theme, user);

		if (subscription != null) {
			subscriptionRepository.delete(subscription);
		}

	}
}
