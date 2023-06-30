package com.example.Miniproject_Market.controller;

import com.example.Miniproject_Market.dto.itemCreateDto;
import com.example.Miniproject_Market.dto.itemDto;
import com.example.Miniproject_Market.service.saleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController // @ResponseBody 포함
@RequestMapping("/items")
@RequiredArgsConstructor
public class saleController {
    private final saleService service;

    // POST /items
    @PostMapping
    public itemCreateDto create(@RequestBody itemCreateDto dto){
        return service.createSale(dto);
    }

    // TODO GET /items?page={page}&limit={limit}





    // GET /items
    @GetMapping
    public List<itemDto> readAll() {
        return service.readSaleAll();
    }

    // GET /items/{itemId}
    @GetMapping("/{id}")
    public itemDto read(@PathVariable("id") Long id) {
        return service.readSale(id);
    }

    // PUT /items/{itemId}
    @PutMapping("/{id}")
    public itemDto update(@PathVariable("id") Long id, @RequestBody itemDto dto) {
        return service.updateSale(id, dto);
    }

    // TODO PUT /items/{itemId}/image





    // DELETE /items/{itemId}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteSale(id);
    }
}

