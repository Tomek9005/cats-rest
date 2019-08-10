package com.sda.catsrest.repository;

import com.sda.catsrest.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
