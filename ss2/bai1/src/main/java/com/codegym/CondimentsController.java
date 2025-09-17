package com.codegym;

import com.codegym.Exception.NoCondimentSelectedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/save")
public class CondimentsController {
    public String save(@RequestParam(value = "condiments", required = false)String [] condiment, Model model){
        if (condiment == null || condiment.length == 0) {
            throw new NoCondimentSelectedException("Chưa chọn nguyên liệu nào!");
        }
        model.addAttribute("result", String.join(", ", condiment));
        return "success";
    }
}
