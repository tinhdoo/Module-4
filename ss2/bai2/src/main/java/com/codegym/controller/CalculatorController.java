package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    private final ICalculatorService calculateService;

    public CalculatorController(ICalculatorService calculateService) {
        this.calculateService = calculateService;
    }

    @RequestMapping
    public String calculate(@RequestParam("numA") double numA,
                            @RequestParam("numB") double numB,
                            @RequestParam("calculator") String calculator,
                            Model model) {
        try {
            double result = calculateService.calculator(numA, numB, calculator);
            model.addAttribute("result", result);
            model.addAttribute("calculator", calculator);
            return "index";
        } catch (ArithmeticException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
