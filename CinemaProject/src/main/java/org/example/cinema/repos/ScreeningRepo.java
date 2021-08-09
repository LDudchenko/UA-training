package org.example.cinema.repos;

import org.example.cinema.domain.Hall;
import org.example.cinema.domain.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningRepo extends JpaRepository<Screening, Long> {
    List<Screening> findAll();
    void deleteById(Long id);
}
