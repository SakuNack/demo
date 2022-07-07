package com.example.demo.feature.common.controllers;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServePageControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test Case 1: Test Load HTML of home screen success")
    void testCase1() {
        ResponseEntity<String> response = restTemplate.exchange("/pages/home", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(), "</html>"));
    }
    @Test
    @DisplayName("Test Case 2: Test Load js of home screen success")
    void testCase2() {
        ResponseEntity<String> response = restTemplate.exchange("/pages/js/home", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(), "//]]>"));
    }

    @Test
    @DisplayName("Test Case 3: Test Load HTML of home screen success")
    void testCase3() {
        ResponseEntity<String> response = restTemplate.exchange("/pages/login", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(), "</html>"));
    }
    @Test
    @DisplayName("Test Case 4: Test Load js of home screen success")
    void testCase4() {
        ResponseEntity<String> response = restTemplate.exchange("/pages/js/login", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(), "//]]>"));
    }
    @Test
    @DisplayName("Test Case 3: Test Load HTML of gimmaster screen success")
    void testCase5() {
        ResponseEntity<String> response = restTemplate.exchange("/pages/master/gim", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(), "</html>"));
    }
    @Test
    @DisplayName("Test Case 4: Test Load js of gimmaster screen success")
    void testCase6() {
        ResponseEntity<String> response = restTemplate.exchange("/pages/js/master/gim", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(StringUtils.endsWith(response.getBody(), "//]]>"));
    }


}
