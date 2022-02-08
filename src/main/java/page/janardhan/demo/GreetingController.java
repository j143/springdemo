package page.janardhan.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping
    public String greeting(String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
