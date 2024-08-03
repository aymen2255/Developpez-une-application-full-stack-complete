package com.openclassrooms.mddapi.services.subscription;

import java.util.List;
import java.util.Set;

import com.openclassrooms.mddapi.entities.Subscription;
import com.openclassrooms.mddapi.entities.Theme;

public interface SubscriptionService {

	List<Theme> getSubscribedThemes();
	
	Subscription subscribeToTheme(Integer themeId);
	
	void unsubscribeUserFromTheme(Integer themeId);
	
	Set<Integer> getSubscribedThemeIds(Integer userId);
}
