package com.example.Miniproject_Market.controller;

import com.example.Miniproject_Market.dto.*;
import com.example.Miniproject_Market.dto.itemDto.*;
import com.example.Miniproject_Market.service.salesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // @ResponseBody 포함
@RequestMapping("/items")
@RequiredArgsConstructor
public class saleController {
    private final salesService service;

    // POST /items
    @PostMapping
    public responseDto create(@RequestBody itemCreateDto dto) { // AOP. 부가 기능(메시지 반환) 추가
        // 판매 게시글 추가
        service.createSale(dto);
        // 메시지
        responseDto response = new responseDto();
        response.setMessage("등록이 완료되었습니다.");
        return response;
    }
//    public itemCreateDto create(@RequestBody itemCreateDto dto){ return service.createSale(dto);}


    // GET /items/{itemId}
    @GetMapping("/{id}")
    public itemReadDto read(@PathVariable("id") Long id) {
        return service.readSale(id);
    }

    // 페이지네이션
    // GET /items?page={page}&limit={limit}
    @GetMapping
    public Page<itemReadDto> readPage(
            @RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "limit", defaultValue = "5") Integer pageSize
    ) {
        return service.readPage(pageNumber, pageSize);
    }


    // PUT /items/{itemId}
    @PutMapping("/{id}")
    public responseDto update(@PathVariable("id") Long id, @RequestBody itemUpdateDto dto) {
        // 판매 페이지 수정
        service.updateSale(id, dto);
        // 메시지
        responseDto response = new responseDto();
        response.setMessage("물품이 수정되었습니다.");
        return response;
    }
//    public itemDto update(@PathVariable("id") Long id, @RequestBody itemDto dto) { return service.updateSale(id, dto);}

    // PUT /items/{itemId}/image
    @PutMapping("/{id}/image")
    public responseDto createImage(@PathVariable("id") Long id) {
        // TODO 이미지 추가


        // 메시지
        responseDto response = new responseDto();
        response.setMessage("이미지가 등록되었습니다.");
        return response;
    }


    // DELETE /items/{itemId}
    @DeleteMapping("/{id}")
    public responseDto delete(@PathVariable("id") Long id, @RequestBody itemDeleteDto dto) {
        // 판매 게시글 삭제
        service.deleteSale(id, dto);
        // 메시지
        responseDto response = new responseDto();
        response.setMessage("물품을 삭제했습니다.");
        return response;
    }
//    public void delete(@PathVariable("id") Long id) { service.deleteSale(id); }
}

