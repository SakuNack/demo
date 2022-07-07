package com.example.demo.feature.common.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class ServePageController {

    @GetMapping("/home")
    public String home() {
        return "home/home.html";
    }

    @GetMapping("/js/home")
    public String homeJs() {
        return "home/home.js";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login.html";
    }

    @GetMapping("/js/login")
    public String loginJs() {
        return "login/login.js";
    }

    @GetMapping("/master/gim")
    public String gimMaster() {
        return "gimmaster/gimmaster.html";
    }

    @GetMapping("/js/master/gim")
    public String gimMasterJs() {
        return "gimmaster/gimmaster.js";
    }


}
