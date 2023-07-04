package com.example.Miniproject_Market.repository;

import com.example.Miniproject_Market.Entity.commentEntity;
import com.example.Miniproject_Market.Entity.negoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface negoRepository extends JpaRepository<negoEntity, Long> {
    Optional<negoEntity> findById(Long id);
    List<negoEntity> findAllByItemId(Long id);

}
