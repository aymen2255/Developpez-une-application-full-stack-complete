package com.openclassrooms.mddapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.openclassrooms.mddapi.entities.Subscription;
import com.openclassrooms.mddapi.entities.Theme;
import com.openclassrooms.mddapi.entities.User;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

	List<Subscription> findByUserId(Integer id);

	Subscription findOneByThemeAndUser(Theme theme, User user);

}
