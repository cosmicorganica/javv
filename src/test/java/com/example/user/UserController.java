package com.example.user;

import com.example.user.controller.UserController;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerTest {

    @Test
    void getAllUsersReturnsList() {
        UserRepository repo = Mockito.mock(UserRepository.class);

        Mockito.when(repo.findAll())
                .thenReturn(List.of(new User("test@example.com", "9999999999")));

        UserController controller = new UserController(repo);

        List<User> users = controller.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("test@example.com", users.get(0).getEmail());
    }
}
