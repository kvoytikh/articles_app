package articles_app.controllers;

import articles_app.model.User;
import articles_app.model.dto.request.UserRequestDto;
import articles_app.service.AuthenticationService;
import articles_app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    private static final String SESSION_ATTRIBUTE = "article_id";
    private UserService userService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/authenticate")
    public String login(Model model) {
        model.addAttribute("loginForm", new UserRequestDto());
        return "users/login";
    }

    @PostMapping("/authenticate")
    public String loginPost(@ModelAttribute("loginForm") UserRequestDto userRequestDto, BindingResult bindingResult,
                            HttpServletRequest req) {
        if (bindingResult.hasErrors()) {
            return "users/login";
        }
        User user = authenticationService.login(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        HttpSession session = req.getSession();
        session.setAttribute(SESSION_ATTRIBUTE, user.getId());
        return "redirect:/articles/add";
    }
}
