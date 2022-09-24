package com.example.diningReview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class diningController {

    @GetMapping("/diningreview")
    public String diningreview() {
        return "Dining Review";
    }
}

