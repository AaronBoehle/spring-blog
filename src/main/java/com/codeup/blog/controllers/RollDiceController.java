package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    @GetMapping("/work/rolldice")
    public String rollDice () {
        return "/work/rolldice";
    }

    @GetMapping("/work/rolldice/{guess}")
    public String rollDice (@PathVariable int guess, Model model) {
        int random = (int) Math.ceil(Math.random()*6);
        String congrats = "Nice guess!";
        model.addAttribute("random", random);
        model.addAttribute("guess", guess);
        model.addAttribute("congrats", congrats);
        return "/work/rolldice";
    }

//     FER EXAMPLE USES NAMES
//    @GetMapping("/rolldice.json")
//    public List<Number> getDice (){
//        List<Number> diceRoll = new ArrayList<>();
//        diceRoll.add(1);
//        diceRoll.add(2);
//        diceRoll.add(3);
//        diceRoll.add(4);
//        diceRoll.add(5);
//        diceRoll.add(6);
//        return diceRoll;
//    }
}
