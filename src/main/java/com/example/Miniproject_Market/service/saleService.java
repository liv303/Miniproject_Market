package com.example.Miniproject_Market.service;

import com.example.Miniproject_Market.Entity.itemEntity;
import com.example.Miniproject_Market.dto.itemCreateDto;
import com.example.Miniproject_Market.dto.itemDto;
import com.example.Miniproject_Market.repository.itemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class saleService {
    private final itemRepository itemRepository;

    public itemCreateDto createSale(itemCreateDto dto) {
        itemEntity newItem = new itemEntity();
        newItem.setTitle(dto.getTitle());
        newItem.setDescription(dto.getDescription());
        newItem.setMinPriceWanted(dto.getMinPriceWanted());
        newItem.setWriter(dto.getWriter());
        newItem.setPassword(dto.getPassword());
        return itemCreateDto.fromEntity(itemRepository.save(newItem));
    }

    public itemDto readSale(Long id) {
        Optional<itemEntity> optionalItemDto = itemRepository.findById(id);
        if (optionalItemDto.isPresent())
            return itemDto.fromEntity(optionalItemDto.get());
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<itemDto> readSaleAll() {
        List<itemDto> itemList = new ArrayList<>();
        for (itemEntity entity: itemRepository.findAll()) {
            itemList.add(itemDto.fromEntity(entity));
        }
        return itemList;
    }

    public itemDto updateSale(Long id, itemDto dto) {
        // TODO 비밀번호 확인 필수
        Optional<itemEntity> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            itemEntity item = optionalItem.get();
            item.setTitle(dto.getTitle());
            item.setDescription(dto.getDescription());
            item.setMinPriceWanted(dto.getMinPriceWanted());
            item.setWriter(dto.getWriter());
            return itemDto.fromEntity(itemRepository.save(item));
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteSale(Long id) {
        if (itemRepository.existsById(id))
            itemRepository.existsById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
