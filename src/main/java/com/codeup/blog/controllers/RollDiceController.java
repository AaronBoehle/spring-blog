package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public String rollDice () {
        return "Guess the outcome of rolling a pair of dice!";
    }

    @GetMapping("/roll-dice/{num}")
    @ResponseBody
    public String rollDice (@PathVariable int num) {
        return "You guessed the results will equal" + num;
    }

    @PostMapping("/roll-dice")
    @ResponseBody
    public int getDiceRoll(@RequestParam(name="diceOne") int rollResults){
        rollResults = (int) Math.random();
        return rollResults;
    }

    // FER EXAMPLE USES NAMES
//    @GetMapping("/test.json")
//    @ResponseBody
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
