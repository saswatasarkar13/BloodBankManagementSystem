package com.spring.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.models.User;
import com.spring.springboot.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public Long getCount() {
        return this.userRepository.count();
    }

    public Long getActiveDonorsCount() {
        return this.userRepository.findActiveDonors();
    }

    public List<User> searchUser(String keyword) {
        return this.userRepository.searchUser(keyword);
    }
}
