package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")
public class ConvertController {
    private final IConvertService convertService;

    public ConvertController(IConvertService convertService) {
        this.convertService = convertService;
    }
    @GetMapping
    public String convert(@RequestParam("usd") double usd, Model model){
        double vnd = convertService.convert(usd);

        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);

        return "result";
    }
}
