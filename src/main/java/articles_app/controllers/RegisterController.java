package articles_app.controllers;

import articles_app.model.dto.request.UserRequestDto;
import articles_app.service.UserService;
import articles_app.service.mapping.request.UserRequestMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private UserService userService;
    private UserRequestMapper userRequestMapper;

    public RegisterController(UserService userService, UserRequestMapper userRequestMapper) {
        this.userService = userService;
        this.userRequestMapper = userRequestMapper;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new UserRequestDto());
        return "users/add";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("userForm") UserRequestDto userRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/add";
        }
        userService.add(userRequestMapper.fromDto(userRequestDto));
        return "redirect:/authenticate";
    }
}
