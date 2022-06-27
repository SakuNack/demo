package com.example.demo.feature.login.controllers;

import com.example.demo.feature.login.dto.LonginDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test case1: login fail with username: testFail and password: 1234@abcd then return false")
    void testCase1() {
        HttpEntity<LonginDTO> request = new HttpEntity<>(new LonginDTO("testFail", "1234@abcd"));
        ResponseEntity<Boolean> response = restTemplate.exchange("/login", HttpMethod.POST, request, Boolean.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Boolean.FALSE, response.getBody());
    }
    @Test
    @DisplayName("Test case1: login fail with username: testPass and password: 1234@abcd then return true")
    void testCase2() {
        HttpEntity<LonginDTO> request = new HttpEntity<>(new LonginDTO("testPass", "1234@abcd"));
        ResponseEntity<Boolean> response = restTemplate.exchange("/login", HttpMethod.POST, request, Boolean.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Boolean.TRUE, response.getBody());
    }

}