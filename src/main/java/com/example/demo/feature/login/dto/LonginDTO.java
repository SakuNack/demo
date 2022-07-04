package com.example.demo.feature.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LonginDTO {
    private String username;
    private String password;
}
