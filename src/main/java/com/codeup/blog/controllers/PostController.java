//package com.codeup.blog.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class PostController {
//
//    @GetMapping ("/posts/index")
//    public String postIndex() {
//        return "/posts/index";
//    }
//
//    @GetMapping ("/posts/{postID}")
//    public String postID(@PathVariable long postID) {
//        return "view an individual post" +postID;
//    }
//
//    @GetMapping ("/posts/create")
//    public String viewForm() {
//        return "view the form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    public String create (@RequestParam (name="createPost") String createPost) {
//        return "create a new post named: " +createPost;
//    }
//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
//}
