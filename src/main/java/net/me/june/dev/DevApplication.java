package net.me.june.dev;

import net.me.june.dev.domain.PostDTO;
import net.me.june.dev.serivice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaAuditing
@Controller
public class DevApplication {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(PostDTO postDTO,Model model) {
        model.addAttribute("posts",postService.findBoards(postDTO));
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DevApplication.class, args);
    }

}
