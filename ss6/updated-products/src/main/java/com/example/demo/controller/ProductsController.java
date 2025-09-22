package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductsNotFoundException;
import com.example.demo.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService service;

    public ProductsController(ProductsService service) {
        this.service = service;
    }

    @GetMapping
    public String showAll(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            model.addAttribute("products", service.searchByName(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("products", service.findAll());
        }
        return "products/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping("/create")
    public String addProduct(@ModelAttribute("product") Product product,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "products/create";
        }
        service.save(product);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") Integer id, Model model) {
        Product product = service.findById(id)
                .orElseThrow(() -> new ProductsNotFoundException("Không tìm thấy sản phẩm với id: " + id));
        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Product product = service.findById(id)
                .orElseThrow(() -> new ProductsNotFoundException("Không tìm thấy sản phẩm với id: " + id));
        model.addAttribute("product", product);
        return "products/view";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") Integer id, Model model) {
        Product product = service.findById(id)
                .orElseThrow(() -> new ProductsNotFoundException("Không tìm thấy sản phẩm với id: " + id));
        model.addAttribute("product", product);
        return "products/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "products/update";
        }
        service.save(product);
        redirect.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/products";
    }
}

