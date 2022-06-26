package com.example.demo.feature.common.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;


public class ServePageControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test Case 1: Response ok")
    void testCase1() {
       /* ResponseEntity<List> response = restTemplate.exchange("/pages/home", HttpMethod.GET, null, List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());*/

    }
}
