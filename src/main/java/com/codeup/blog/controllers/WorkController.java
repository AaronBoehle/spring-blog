package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkController {

    @GetMapping("/work/index")
    public String work () {
        return "/work/index";
    }
}
