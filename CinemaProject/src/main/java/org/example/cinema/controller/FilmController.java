package org.example.cinema.controller;

import lombok.SneakyThrows;
import org.example.cinema.domain.Film;
import org.example.cinema.repos.FilmRepo;
import org.example.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

@Controller
@PropertySource("classpath:messages.properties")
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping
    public String filmList(Model model){
        model.addAttribute("films", filmService.findAll());
        return "filmList";
    }

    @GetMapping("{film}")
    public String userEditForm(@PathVariable Film film, Model model){
        model.addAttribute("film", film);
        model.addAttribute("description", film.getDescription());
        return "filmEdit";
    }

    @GetMapping("/add")
    public String addFilmPage(){
        return "addFilm";
    }

    @SneakyThrows
    @PostMapping("/add")
    public String addFilm(@RequestParam String name,
                          @RequestParam String description,
                          @RequestParam String name_en,
                          @RequestParam String description_en,
                          @RequestParam int duration){
        filmService.add(name, description, name_en, description_en, duration);
        return "redirect:/films";
    }

    @GetMapping("/delete/{film}")
    public String filmDelete(@PathVariable Film film, Model model){
        filmService.delete(film);
        return "redirect:/films";
    }

    @SneakyThrows
    @PostMapping
    public String filmSave(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String name_en,
            @RequestParam String description_en,
            @RequestParam int duration,
            @RequestParam("filmId") Film film){
        filmService.save(name, description, name_en, description_en, film, duration);
        return "redirect:/films";
    }
}
