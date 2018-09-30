package pl.piotrekcz.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> users = new ArrayList<>();

    @GetMapping("/users")
    public String usersList(Model model) {
        userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/addUser")
    public String add(Model model) {
        userRepository.findAll();
        model.addAttribute("newUser", new User());
        return "users";
    }

    @PostMapping("/addUser")
    public String add(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }
}
