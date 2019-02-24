package net.me.june.dev.web;

import groovy.util.logging.Log4j;
import lombok.AllArgsConstructor;
import net.me.june.dev.domain.Post;
import net.me.june.dev.domain.PostDTO;
import net.me.june.dev.security.LoginVO;
import net.me.june.dev.security.SecurityUtils;
import net.me.june.dev.serivice.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/posts")
@Log4j
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String list(
        PostDTO postDTO
        ,Model model
    ){
        List<Post> posts = postService.findBoards(postDTO);
        model.addAttribute("posts",posts);
        return "posts/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("posts",new Post());
        return "posts/form";
    }

    @PostMapping
    public String createPost(
            @Valid PostDTO postDTO
            , BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            return "posts/form";
        }
        LoginVO user = SecurityUtils.getUsers();
        postService.createPost(postDTO,user);
        return "redirect:/posts";
    }
}
