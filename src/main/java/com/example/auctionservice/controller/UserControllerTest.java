package com.example.auctionservice.controller;

import com.example.auctionservice.model.User;
import com.example.auctionservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUserByEmail() throws Exception {
        User user = new User();
        user.setEmail("test@example.com");
        when(userService.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/email")
                        .param("email", "test@example.com"))
                .andExpect(status().isOk());
    }
}
