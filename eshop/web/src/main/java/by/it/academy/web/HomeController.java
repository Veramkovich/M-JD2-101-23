package by.it.academy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings({"unused"})
@Controller
public class HomeController {

    @GetMapping({"/", "/index.jsp", "/index.html", "/home"})
    public String getHomePage() {
        return "index";
    }

}
