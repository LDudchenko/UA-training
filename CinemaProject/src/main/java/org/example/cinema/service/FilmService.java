package org.example.cinema.service;

import lombok.SneakyThrows;
import org.example.cinema.domain.Film;
import org.example.cinema.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class FilmService {
    @Autowired
    private FilmRepo filmRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @SneakyThrows
    public void add(String name, String description, String name_en, String description_en){
        Film film = new Film();
        film.setName(name);
        film.setName_en(name_en);
        film.setDescription(description);
        film.setDescription_en(description_en);
        filmRepo.save(film);
    }

    public void delete(Film film){
        filmRepo.deleteById(film.getId());
    }

    @SneakyThrows
    public void save(String name, String description, String name_en,
                     String description_en, Film film){
        film.setName(name);
        film.setName_en(name_en);
        film.setDescription(description);
        film.setDescription_en(description_en);
        filmRepo.save(film);
    }

    public List<Film> findAll(){
        return filmRepo.findAll();
    }
}
