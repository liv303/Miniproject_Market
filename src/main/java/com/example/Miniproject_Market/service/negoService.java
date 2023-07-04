package com.example.Miniproject_Market.service;

import com.example.Miniproject_Market.Entity.itemEntity;
import com.example.Miniproject_Market.Entity.negoEntity;
import com.example.Miniproject_Market.repository.negoRepository ;
import com.example.Miniproject_Market.dto.negoDto.negoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class negoService {
    private negoRepository negoRepository;


    // 제안 등록
    public negoDto createNego(Long itemId, negoDto dto) {
        negoEntity newNego = new negoEntity();


        // 제안 등록: 비밀번호 추가
        newNego.setItemId(itemId);
        newNego.setSuggestedPrice(dto.getSuggestedPrice());
        newNego.setStatus("제안");    // 제안 등록시 "제안" 상태로
        newNego.setWriter(dto.getWriter());
        newNego.setPassword(dto.getPassword());
        return negoDto.fromNegoEntity(negoRepository.save(newNego));
    }


    // 제안 조회
    // GET /items/{itemId}/proposals?writer=jeeho.edu&password=qwerty1234&page=1


    // 제안 수정


    // 제안 삭제


}
