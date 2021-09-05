package org.example.cinema.repos;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {
    List<Film> findAll();
    void deleteById(Long id) throws DataIntegrityViolationException;
}
