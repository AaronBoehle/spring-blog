package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    // functions that interact with our DaoFactory
    @GetMapping ("/posts")
    public String all(Model model) {
        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping ("/posts/{id}")
    public String show (@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping ("/posts/create")
    public String view() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create (@RequestParam (name="title") String title,
                          @RequestParam (name="body") String body)
    {
        Post post = new Post (title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "/posts/edit";
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