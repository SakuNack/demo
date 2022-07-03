package com.example.demo.feature.login.controllers;

import com.example.demo.feature.login.dto.LonginDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping("")
    public Boolean login(@RequestBody final LonginDTO longinDTO) {
        return StringUtils.equalsIgnoreCase(longinDTO.getUsername(), "testpass")
                && StringUtils.equalsIgnoreCase(longinDTO.getPassword(), "1234@abcd");

    }
}