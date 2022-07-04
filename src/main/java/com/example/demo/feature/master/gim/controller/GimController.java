package com.example.demo.feature.master.gim.controller;

import com.example.demo.data.mybatis.models.GimHeaderModel;
import com.example.demo.feature.master.gim.dto.GimHeaderSearchResultDTO;
import com.example.demo.feature.master.gim.service.GimMasterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/master/gim")
@RequiredArgsConstructor
public class GimController {
    private final GimMasterService service;
    private final ModelMapper mapper;

    @GetMapping("/header/all")
    public List<GimHeaderSearchResultDTO> getAllGimHeader() {
        return service.getAllGimHeader().stream().map(this::convertGimHeaderModelToDTO).collect(Collectors.toList());
    }

    private GimHeaderSearchResultDTO convertGimHeaderModelToDTO(GimHeaderModel model) {
        return mapper.map(model, GimHeaderSearchResultDTO.class);
    }
}
