package com.codeup.blog.controllers;

import com.codeup.blog.models.Category;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.PostImage;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @Autowired
    Users userDao;

    // functions that interact with our DaoFactory
    @GetMapping ("/posts")
    public String all(Model model) {
        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping ("/posts/{id}")
    public String show (@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping ("/posts/create")
    public String view() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create (@RequestParam (name="title") String title,
                          @RequestParam (name="body") String body
                          )
    {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = userDao.findOne(sessionUser.getId());

        List<PostImage> images = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        Post post = new Post (title, body, userDB);
        postDao.save(post);
        return "redirect:/posts";

    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id,
                         @RequestParam(name="title") String title,
                         @RequestParam(name="body") String body,
                         Model model)
    {
        Post post = postDao.findOne(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete")
    public String delete(@RequestParam (name="id") long id)
    {
        //Searches for the post by ID and deletes
        Post post = postDao.findOne(id);
        postDao.delete(post);

        return "redirect:/posts";
    }
}
