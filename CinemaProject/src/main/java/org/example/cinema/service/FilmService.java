package org.example.cinema.service;

import lombok.SneakyThrows;
import org.example.cinema.domain.Film;
import org.example.cinema.domain.Screening;
import org.example.cinema.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class FilmService {
    @Autowired
    private FilmRepo filmRepo;

    public void add(String name, String description, String name_en, String description_en, int duration){
        Film film = new Film();
        film.setName(name);
        film.setName_en(name_en);
        film.setDescription(description);
        film.setDescription_en(description_en);
        film.setDurationInMinutes(duration);
        filmRepo.save(film);
    }

    public boolean delete(Film film) throws DataIntegrityViolationException {
        if(filmRepo.existsById(film.getId())) {
            filmRepo.deleteById(film.getId());
            return true;
        }
        return false;
    }

    public void save(String name, String description, String name_en,
                     String description_en, Film film, int duration){
        film.setName(name);
        film.setName_en(name_en);
        film.setDescription(description);
        film.setDescription_en(description_en);
        film.setDurationInMinutes(duration);
        filmRepo.save(film);
    }

    public List<Film> findAll(){
        return filmRepo.findAll();
    }
}
