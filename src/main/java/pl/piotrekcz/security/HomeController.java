package pl.piotrekcz.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/logowanie")
    public String logowanie(){
        return "logowanie";
    }

    @GetMapping("/rejestracja")
    public String rejestracja(){
        return "rejestracja";
    }
}
