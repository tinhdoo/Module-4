package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    private final IDictionaryService iDictionaryService;

    public DictionaryController(IDictionaryService iDictionaryService) {
        this.iDictionaryService = iDictionaryService;
    }

    @PostMapping
    public String doDictionary(@RequestParam("eng") String eng, Model model) {
        String vie = iDictionaryService.translate(eng);
        model.addAttribute("eng", eng);
        model.addAttribute("vie", vie);
        return "result";
    }

    @RequestMapping
    public String showForm() {
        return "index";
    }
}
