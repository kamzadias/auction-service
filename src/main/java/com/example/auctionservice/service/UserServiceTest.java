package com.example.auctionservice.service;

import static org.mockito.Mockito.*;

import com.example.auctionservice.model.User;
import com.example.auctionservice.repository.UserRepository;
import com.example.auctionservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
    }

    @Test
    public void testFindByEmail() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findByEmail(user.getEmail());
        assertTrue(foundUser.isPresent());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
    }

    @Test
    public void testSaveUser() {
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);
        assertEquals(user.getEmail(), savedUser.getEmail());
    }
}
