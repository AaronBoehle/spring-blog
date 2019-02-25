package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping ("/posts")
    @ResponseBody
    public String postIndex() {
        return "posts index page";
    }

    @GetMapping ("/posts/{postID}")
    @ResponseBody
    public String postID(@PathVariable long postID) {
        return "view an individual post" +postID;
    }

    @GetMapping ("/posts/create")
    @ResponseBody
    public String viewForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create (@RequestParam (name="createPost") String createPost) {
        return "create a new post named: " +createPost;
    }
}
