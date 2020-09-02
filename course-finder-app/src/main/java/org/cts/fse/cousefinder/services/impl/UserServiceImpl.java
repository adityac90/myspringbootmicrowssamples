package org.cts.fse.cousefinder.services.impl;

import org.cts.fse.cousefinder.model.ApplicationUser;
import org.cts.fse.cousefinder.repository.UserRepository;
import org.cts.fse.cousefinder.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApplicationUser signUp(ApplicationUser applicationUser) {
        return userRepository.save(applicationUser);
    }
}
