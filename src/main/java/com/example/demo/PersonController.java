package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    @GetMapping
    String getPeople(Model model){
            model.addAttribute("something", "This is controller speaking");
            return "people";
        }

        @RequestMapping(value = "/gameScreen", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gameScreen");
        modelAndView.addObject("user", user);
        return modelAndView;
        }
        @RequestMapping(value = "/play", method = RequestMethod.POST)
    public ModelAndView attempt(@ModelAttribute TheGame game) {
        game.play();
        System.out.println("tiku sheit");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("game", game);
        return modelAndView;
    }
}
