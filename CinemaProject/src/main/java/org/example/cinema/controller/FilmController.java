package org.example.cinema.controller;

import lombok.SneakyThrows;
import org.example.cinema.domain.Film;
import org.example.cinema.repos.FilmRepo;
import org.example.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Value("${upload.path}")
    private String uploadPath;

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
                          @RequestParam String description_en){
        filmService.add(name, description, name_en, description_en);
        return "redirect:/films";
    }

    @GetMapping("/delete/{film}")
    public String filmDelete(@PathVariable Film film){
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
            @RequestParam("filmId") Film film){
        filmService.save(name, description, name_en, description_en, film);

        return "redirect:/films";
    }
}
