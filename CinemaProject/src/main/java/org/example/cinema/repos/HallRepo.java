package org.example.cinema.repos;

import org.example.cinema.domain.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepo extends JpaRepository<Hall, Long> {
    List<Hall> findAll();
    void deleteById(Long id);
}
