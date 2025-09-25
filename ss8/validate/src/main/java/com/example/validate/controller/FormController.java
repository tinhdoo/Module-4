package com.example.validate.controller;

import com.example.validate.model.User;
import com.example.validate.service.IUserService;
import com.example.validate.validate.AgeValidate;
import com.example.validate.validate.UniqueEmailValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.validate.dto.UserDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class FormController {
    private final IUserService userService;

    public FormController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String  getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "result";
    }

    @GetMapping("/create")
    public String createUser(ModelMap modelMap){
        modelMap.addAttribute("userDto", new UserDto()); // ✅ khớp với form
        return "index";
    }


    @PostMapping("/create")
    public String createStudent(@Validated @ModelAttribute("userDto") UserDto userDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirect,
                                Model model) {
        AgeValidate ageValidate = new AgeValidate();
        ageValidate.validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "index";
        }

        User student = new User();
        BeanUtils.copyProperties(userDto, student);
        userService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/form";
    }


}
