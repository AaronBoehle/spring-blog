package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping ("/posts")
    @ResponseBody
    public String postIndex() {
        return "posts index page";
    }

    @GetMapping ("/posts/{postID}")
    @ResponseBody
    public String postID(@PathVariable int postID) {
        return "view an individual post";
    }

    @GetMapping ("/posts/create")
    @ResponseBody
    public String postCreateForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreateNew () {
        return "create a new post";
    }
}
