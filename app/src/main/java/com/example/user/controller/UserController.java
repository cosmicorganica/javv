package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Handles HTML form submission (POST /users)
    @PostMapping
    public String saveUser(@RequestParam String email,
                           @RequestParam String phone,
                           Model model) {

        repository.save(new User(email, phone));

        model.addAttribute("email", email);
        model.addAttribute("phone", phone);

        return "success";
    }

    // REST endpoint (GET /users)
    @GetMapping
    @ResponseBody
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
