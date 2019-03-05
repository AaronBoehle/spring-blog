package com.codeup.blog.controllers;

import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserRepository userDao;

    public UserController (UserRepository userDao){
        this.userDao = userDao;

    }

    @Autowired
    private EmailService emailService;

    @GetMapping("/users/create")
    public String view(){
        return "users/create";
    }

    @PostMapping("/users/create")
    public String create (@RequestParam(name="username") String username,
                          @RequestParam (name="email") String email,
                          @RequestParam(name="password") String password)
    {
        if (username.isEmpty() && email.isEmpty() && password.isEmpty()){

        }
        User user = new User (username, email, password);
        User savedUser = userDao.save(user);
        emailService.prepareAndSend(savedUser, "User created successfully", "Your profile was created with the id " +savedUser.getId());
        return "redirect:/users/show";
    }
}
