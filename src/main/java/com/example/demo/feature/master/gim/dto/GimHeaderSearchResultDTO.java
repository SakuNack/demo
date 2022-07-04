package com.example.demo.feature.master.gim.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GimHeaderSearchResultDTO {
    private String gimType;
    private String gimDesc;
    private String cdLength;
    private String field1Label;
    private String field2Label;
    private String field3Label;
    private String activeFlag;
    private String createdBy;
    private String createdDt;
    private String modifiedBy;
    private String modifiedDt;
}
