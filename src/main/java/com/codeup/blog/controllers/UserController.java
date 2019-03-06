package com.codeup.blog.controllers;

import com.codeup.blog.models.User;
import com.codeup.blog.repositories.Users;
import com.codeup.blog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
//    private final Users userDao;
    private final Users users;
    private PasswordEncoder passwordEncoder;

    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

//    public UserController (Users userDao){
//        this.userDao = userDao;
//    }

    @Autowired
    private EmailService emailService;

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }
    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

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
        User savedUser = users.save(user);
        emailService.prepareAndSend(savedUser, "User created successfully", "Your profile was created with the id " +savedUser.getId());
        return "redirect:/users/show";
    }
}
