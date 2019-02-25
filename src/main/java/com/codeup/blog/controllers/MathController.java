package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public String addition (@PathVariable int numOne, @PathVariable int numTwo) {
        int sumOf = numOne+numTwo;
        return String.valueOf(sumOf);
    }

    @GetMapping("/subtract/{numOne}/from/{numTwo}")
    @ResponseBody
    public String subtract (@PathVariable int numOne, @PathVariable int numTwo) {
        int differenceOf = numTwo-numOne;
        return String.valueOf(differenceOf);
    }

    @GetMapping("/multiply/{numOne}/and/{numTwo}")
    @ResponseBody
    public String multiply (@PathVariable int numOne, @PathVariable int numTwo) {
        int productOf = numOne*numTwo;
        return String.valueOf(productOf);
    }

    @GetMapping("/divide/{numOne}/by/{numTwo}")
    @ResponseBody
    public String divide (@PathVariable int numOne, @PathVariable int numTwo) {
        int quotientOf = numOne/numTwo;
        return String.valueOf(quotientOf);
    }

    @GetMapping("/random/between/{min}/and/{max}")
    @ResponseBody
    public String randomNumber (@PathVariable double min, @PathVariable double max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return String.valueOf((int) Math.floor(Math.random()*(max-min+1)+min));
    }
}
