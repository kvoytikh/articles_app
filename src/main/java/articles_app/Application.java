package articles_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableCaching
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @RequestMapping("/")
    public String loginPage() {
        return "users/login";
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
