package by.it.academy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping(value = "/welcome")
    public ModelAndView showWelcomePage(ModelAndView modelAndView) {
        //Add model
        modelAndView.addObject("message", "Welcome to Spring web MVC");
        modelAndView.setViewName("welcome");

        // Return view name
        return modelAndView;
    }

}
