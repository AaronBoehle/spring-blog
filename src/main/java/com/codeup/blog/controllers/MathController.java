package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public int addition (@PathVariable int numOne, @PathVariable int numTwo) {
        int sumOf = numOne+numTwo;
        return sumOf;
    }

    @GetMapping("/subtract/{numOne}/from/{numTwo}")
    @ResponseBody
    public int subtract (@PathVariable int numOne, @PathVariable int numTwo) {
        int differenceOf = numTwo-numOne;
        return differenceOf;
    }

    @GetMapping("/multiply/{numOne}/and/{numTwo}")
    @ResponseBody
    public int multiply (@PathVariable int numOne, @PathVariable int numTwo) {
        int productOf = numOne*numTwo;
        return productOf;
    }

    @GetMapping("/divide/{numOne}/by/{numTwo}")
    @ResponseBody
    public int divide (@PathVariable int numOne, @PathVariable int numTwo) {
        int quotientOf = numOne/numTwo;
        return quotientOf;
    }
}
