package com.example.auctionservice.service;

import com.example.auctionservice.model.User;
import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    User saveUser(User user);
    // Дополнительные методы для управления пользователями
}
