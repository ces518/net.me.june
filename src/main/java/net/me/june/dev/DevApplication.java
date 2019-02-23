package net.me.june.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaAuditing
@Controller
public class DevApplication {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DevApplication.class, args);
    }

}
