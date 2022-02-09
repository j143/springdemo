package page.janardhan.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/simple-message")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello, World");
    }

    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("**== Receive Greetings ==**");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    // Note that here CrossOrigin annotation is not used but specified
    // in the application class
    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        System.out.println("**== Greeting with Java Config ==**");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
