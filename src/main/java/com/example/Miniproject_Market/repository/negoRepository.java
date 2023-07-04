package com.example.Miniproject_Market.repository;

import com.example.Miniproject_Market.Entity.negoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface negoRepository extends JpaRepository<negoEntity, Long> {
}
