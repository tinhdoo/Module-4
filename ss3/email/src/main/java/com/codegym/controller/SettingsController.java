package com.codegym.controller;

import com.codegym.entity.MailSettings;
import com.codegym.service.MailSettingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/settings")
public class SettingsController {
    private final MailSettingsService mailSettingsService;

    public SettingsController(MailSettingsService mailSettingsService) {
        this.mailSettingsService = mailSettingsService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("settings", mailSettingsService.getSettings());
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "settings";
    }

    @PostMapping
    public String update(@ModelAttribute("settings") MailSettings settings, Model model) {
        mailSettingsService.updateSettings(settings);
        model.addAttribute("settings", settings);
        model.addAttribute("message", "Update successfully!");
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "settings";
    }
}
