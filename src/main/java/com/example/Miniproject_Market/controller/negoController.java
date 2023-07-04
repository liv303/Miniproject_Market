package com.example.Miniproject_Market.controller;

import com.example.Miniproject_Market.Entity.itemEntity;
import com.example.Miniproject_Market.Entity.negoEntity;
import com.example.Miniproject_Market.dto.negoDto.negoDto;
import com.example.Miniproject_Market.dto.responseDto;
import com.example.Miniproject_Market.service.negoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/items/{itemId}")
@RequiredArgsConstructor
public class negoController {
    private final negoService service;

    // 제안 등록
    // POST /items/{itemId}/proposal
    @PostMapping("/proposal")
    public responseDto create(@PathVariable("itemId") Long itemId, @RequestBody negoDto dto) {
        // 제안 생성
        service.createNego(itemId, dto);
        // 메시지
        responseDto response = new responseDto();
        response.setMessage("구매 제안이 등록되었습니다.");
        return response;
    }

    // 제안 조회
    // GET /items/{itemId}/proposals?writer=jeeho.edu&password=qwerty1234&page=1
    @GetMapping("/proposals")
    public List<negoDto> read(
            @PathVariable("itemId") Long itemId,
            @RequestParam(value = "writer") String writer,
            @RequestParam(value = "password") String password
            ) {

        // TODO 페이지 단위 조회 제공

            return service.readNego(itemId, writer, password);
    }

    // 제안 수정
    // PUT /items/{itemId}/proposals/{proposalId}
    public void update() {
    }

    // 제안 수락/거절
    // PUT /items/{itemId}/proposals/{proposalId}
    public void status() {
    }

    // 제안 확정
    // PUT /items/{itemId}/proposals/{proposalId}
    public void acceptProposal() {
    }

    // 제안 삭제
    // DELETE /items/{itemId}/proposals/{proposalId}
    @DeleteMapping("/proposals/{proposalId}")
    public responseDto delete(@PathVariable("itemId") Long itemId,
                              @PathVariable("proposalId") Long proposalId,
                              @RequestBody Map<String, String> user // 작성자, 비밀번호 확인용
                              ) {
        // 삭제(작성자, 비밀번호 확인)
        String writer = user.get("writer");
        String password = user.get("password");
        service.deleteNego(proposalId, writer, password);
        //메시지
        responseDto response = new responseDto();
        response.setMessage("제안을 삭제했습니다.");
        return response;
    }



}
