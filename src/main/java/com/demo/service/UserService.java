package com.demo.service;

import com.demo.entity.User;
import com.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userRepository;

    /**
     * @return user info
     */
    public User getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = Integer.valueOf(authentication.getName());

        return userRepository.findById(userId).get();
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }
}
