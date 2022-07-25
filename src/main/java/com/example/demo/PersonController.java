package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class PersonController {

    public List<Attempt> attempts = new ArrayList<>();
    private List<Integer> secretNum = new ArrayList<>();
    boolean isRight = false;
    boolean gameOver = false;
    int counter = 0;
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
        return modelAndView;
    }

    @RequestMapping(value = "/play", method = {RequestMethod.POST})
    public ModelAndView execute(@ModelAttribute TheGame game) {
        if (secretNum.isEmpty()) {
            secretNum = game.generateNumber();
        }
        Attempt previousAttempt = game.play(secretNum);
        counter ++;
        if (counter >= 8) {
            gameOver = true;
            secretNum = new ArrayList<>();
            counter = 0;
            attempts = new ArrayList<>();
            ModelAndView tryAgainScreen = new ModelAndView();
            tryAgainScreen.setViewName("gameOver");
            return tryAgainScreen;
        }
        attempts.add(previousAttempt);
        if (secretNum.equals(attempts.get(attempts.size()-1).inputs)) {
            isRight = true;
            secretNum = new ArrayList<>();
            attempts = new ArrayList<>();
            ModelAndView gameWonScreen = new ModelAndView();
            gameWonScreen.setViewName("gameWon");
            return gameWonScreen;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("attempts", attempts);
        return modelAndView;
    }
}
