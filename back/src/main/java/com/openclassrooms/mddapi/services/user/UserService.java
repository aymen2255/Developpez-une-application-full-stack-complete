package com.openclassrooms.mddapi.services.user;

import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.entities.User;

@Service
public interface UserService {

	User getUser();
}
