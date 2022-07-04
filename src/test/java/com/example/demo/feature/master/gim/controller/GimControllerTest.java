package com.example.demo.feature.master.gim.controller;

import com.example.demo.feature.master.gim.dto.GimHeaderSearchResultDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GimControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate ;
    @Test
    @DisplayName("Test case1: Retrieve All Gim Header Data")
    void testcase1(){
        ResponseEntity<List<GimHeaderSearchResultDTO>> response = testRestTemplate.exchange("/master/gim/header/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<GimHeaderSearchResultDTO>>() {
        });
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<GimHeaderSearchResultDTO> resultDTOList = response.getBody();
        assertNotNull(resultDTOList);
        assertEquals(163,response.getBody().size());
        assertEquals("WARRANTY_CLAIM_PERIOD",response.getBody().get(162).getGimType());
    }

}