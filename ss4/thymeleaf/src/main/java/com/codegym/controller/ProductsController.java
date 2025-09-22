package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.exception.ProductsNotFoundException;
import com.codegym.service.IProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final IProductsService service;

    public ProductsController(IProductsService service) {
        this.service = service;

    }

    @GetMapping
    public String showAll(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            model.addAttribute("products", service.searchByName(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            model.addAttribute("products", service.showAll());
        }
        return "product/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "product/create";
    }
    @PostMapping("/create")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        service.save(product);
        redirect.addFlashAttribute("message", "Thêmm mới thành công");
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") Integer id, Model model) {
        Product product = service.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/delete"; // mở delete.html
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Product product = service.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") Integer id, Model model) {
        Product product = service.findById(id);
        if (id == null){
            throw new ProductsNotFoundException("Không tìm thấy sản phẩm với id: " + id);
        }
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product,
                       BindingResult bindingResult,
                       RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "product/update";
        }
        service.save(product);
        redirect.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/products";
    }
}
