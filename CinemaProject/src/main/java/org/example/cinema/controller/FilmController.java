package org.example.cinema.controller;

import lombok.SneakyThrows;
import org.example.cinema.domain.Film;
import org.example.cinema.repos.FilmRepo;
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
    private FilmRepo filmRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String filmList(Model model){
        model.addAttribute("films", filmRepo.findAll());
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
                          @RequestParam("file") MultipartFile file){
        Film film = new Film();

        if(file!=null){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath+"/"+resultFilename));

            film.setFilename(resultFilename);
        }

        film.setName(name);
        film.setName_en(name_en);
        film.setDescription(description);
        film.setDescription_en(description_en);
        filmRepo.save(film);

        return "redirect:/films";
    }

    @GetMapping("/delete/{film}")
    public String filmDelete(@PathVariable Film film){
        filmRepo.deleteById(film.getId());
        return "redirect:/films";
    }

    @SneakyThrows
    @PostMapping
    public String filmSave(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String name_en,
            @RequestParam String description_en,
            @RequestParam("filmId") Film film,
            @RequestParam("file") MultipartFile file){
        film.setName(name);
        film.setName_en(name_en);
        film.setDescription(description);
        film.setDescription_en(description_en);

        if(file!=null){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath+"/"+resultFilename));

            film.setFilename(resultFilename);
        }

        filmRepo.save(film);

        return "redirect:/films";
    }


}
