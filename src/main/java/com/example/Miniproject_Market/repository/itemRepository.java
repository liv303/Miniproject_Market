package com.example.Miniproject_Market.repository;

import com.example.Miniproject_Market.Entity.itemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface itemRepository extends JpaRepository<itemEntity, Long> {
    List<itemEntity> findAllByIdContains(Long id);
    Page<itemEntity> findAllByIdContains(Long id, Pageable pageable);
}
