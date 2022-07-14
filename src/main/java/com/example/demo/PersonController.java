package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    @GetMapping
    String getPeople(Model model) {
        model.addAttribute("something", "Welcome to this guessing game");
        return "people";
    }
    @RequestMapping(value = "/gameScreen", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gameScreen");
        modelAndView.addObject("user", user);
       /* if (user.getName() == null || user.getName() == ""){
            return
        }*/
        return modelAndView;
    }
    @RequestMapping(value = "/play", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView attempt(@ModelAttribute TheGame game, HttpServletResponse response) {
        game.generateNumber();
        game.play();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("game", game);
        //viena liela probza zemāk
/*        Cookie cookie = new Cookie("jsonAttempt", );
        response.addCookie(cookie);*/
        return modelAndView;
    }
}
