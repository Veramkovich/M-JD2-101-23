package by.it.academy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView showWelcomePage(ModelAndView modelAndView) {
        //Add model
        modelAndView.addObject("message", "Welcome to Spring web MVC");
        modelAndView.setViewName("welcome");

        // Return view name
        return modelAndView;
    }

}
