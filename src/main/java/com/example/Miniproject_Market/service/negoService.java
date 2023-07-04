package com.example.Miniproject_Market.service;

import com.example.Miniproject_Market.Entity.negoEntity;
import com.example.Miniproject_Market.repository.negoRepository;
import com.example.Miniproject_Market.dto.negoDto.negoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class negoService {
    private final negoRepository negoRepository;
    // 제안 등록
    public negoDto createNego(Long itemId, negoDto dto) {
        negoEntity newNego = new negoEntity();
        newNego.setItemId(itemId);
        newNego.setSuggestedPrice(dto.getSuggestedPrice());
        newNego.setStatus("제안");    // 제안 등록시 "제안" 상태로
        newNego.setWriter(dto.getWriter());
        newNego.setPassword(dto.getPassword());
        return negoDto.fromNegoEntity(negoRepository.save(newNego));
    }

    // 제안 조회
    // GET /items/{itemId}/proposals?writer=jeeho.edu&password=qwerty1234&page=1
    public List<negoDto> readNego(Long itemId, String writer, String password) {
        // 게시글이 존재하는지 확인
        Optional<negoEntity> optionalNegoEntity = negoRepository.findById(itemId);
        if (optionalNegoEntity.isEmpty()){ throw new ResponseStatusException(HttpStatus.NOT_FOUND); }

        negoEntity negoEntity = optionalNegoEntity.get();   // 옵셔널 객체 가져옴
        // 작성자가 맞는지 확인(작성자, 비밀번호)
        if (
                writer.equals(negoEntity.getWriter())
                && password.equals(negoEntity.getPassword())
        ) {
            // 작성자가 맞다면 조회
            List<negoDto> negoDtoList = new ArrayList<>();
            for (negoEntity entity : negoRepository.findAllByItemId(itemId)) {
                negoDtoList.add(negoDto.fromNegoEntity(entity));
            }
            return negoDtoList;
        }
        // 작성자가 아니라면 예외 발생
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


    // 제안 수정
    // PUT /items/{itemId}/proposals/{proposalId}
    public void updateNego() {
    }

    // 제안 수락/거절
    // PUT /items/{itemId}/proposals/{proposalId}


    // 제안 확정
    // PUT /items/{itemId}/proposals/{proposalId}


    // 제안 삭제
    // DELETE /items/{itemId}/proposals/{proposalId}
    public void deleteNego(Long proposalId, String writer, String password) {
//        // 제안글이 존재하는지 확인
        Optional<negoEntity> optionalNegoEntity = negoRepository.findById(proposalId);
        if (optionalNegoEntity.isEmpty()){ throw new ResponseStatusException(HttpStatus.NOT_FOUND); }

        negoEntity negoEntity = optionalNegoEntity.get();   // 옵셔널 객체 가져옴
        // 작성자가 맞는지 확인(작성자, 비밀번호)
        if (writer.equals(negoEntity.getWriter())
                && password.equals(negoEntity.getPassword())
        ) {
            // 작성자가 맞다면 삭제
            negoRepository.deleteById(proposalId);
        }
        // 작성자가 아니라면 예외 발생
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
