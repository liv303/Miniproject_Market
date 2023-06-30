package com.example.Miniproject_Market.repository;

import com.example.Miniproject_Market.Entity.itemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface itemRepository extends JpaRepository<itemEntity, Long> {

}
