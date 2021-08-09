package org.example.cinema.repos;

import org.example.cinema.domain.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepo extends JpaRepository<Hall, Long> {
    List<Hall> findAll();
    void deleteById(Long id);
}
