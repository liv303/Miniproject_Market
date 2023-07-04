package com.example.Miniproject_Market.controller;

import com.example.Miniproject_Market.dto.negoDto.negoDto;
import com.example.Miniproject_Market.service.negoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items/{itemId}")
@RequiredArgsConstructor
public class negoController {
    private final negoService service;

    // 제안 등록
    // POST /items/{itemId}/proposal
    @PostMapping("/proposal")
    public negoDto create(@PathVariable("itemId") Long itemId, @RequestBody negoDto dto) {
        return service.createNego(itemId, dto);
    }



}
