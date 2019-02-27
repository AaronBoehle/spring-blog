package com.codeup.blog.posts;

import com.codeup.blog.posts.Post;
import com.codeup.blog.posts.PostRepository;
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
    public String show(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping ("/posts/create")
    public String viewForm() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create (@RequestParam (name="createPost") String createPost) {
        return "/posts/create";
    }
}
