package ru.netology.daolayer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daolayer.service.DaoService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class DaoController {
    private final DaoService service;

    public DaoController(DaoService service) {
        this.service = service;
    }

    @GetMapping("/fetch-product")
    public List<String> getProduct(@RequestParam("name") String name) {
        return service.getProduct(name);
    }
}
