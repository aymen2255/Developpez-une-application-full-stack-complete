package com.openclassrooms.mddapi.services.subscription;

import java.util.List;

import com.openclassrooms.mddapi.entities.Theme;

public interface SubscriptionService {

	List<Theme> getSubscribedThemes();
}
