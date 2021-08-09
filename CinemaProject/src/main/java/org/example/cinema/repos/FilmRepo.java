package org.example.cinema.repos;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Long> {
    List<Film> findAll();
    void deleteById(Long id);
}
