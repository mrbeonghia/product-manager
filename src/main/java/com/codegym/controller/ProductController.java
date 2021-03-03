package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public String listCustomer(Model model){
        List productList = productService.findAll();
        model.addAttribute("products",productList);
        return "index";
    }

    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("save")
    public String save(Product product){
        product.setId((int)(Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String update(Product product){
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
