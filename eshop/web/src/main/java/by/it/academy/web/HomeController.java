package by.it.academy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/index.jsp", "/index.html"})
    public String getHomePage() {
        return "index";
    }

}
