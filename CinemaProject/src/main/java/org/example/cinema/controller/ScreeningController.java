package org.example.cinema.controller;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Hall;
import org.example.cinema.domain.Screening;
import org.example.cinema.repos.FilmRepo;
import org.example.cinema.repos.HallRepo;
import org.example.cinema.repos.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping("/screenings")
public class ScreeningController {
    @Autowired
    private ScreeningRepo screeningRepo;

    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private HallRepo hallRepo;

    @GetMapping
    public String screeningList(Model model){
        model.addAttribute("screenings", screeningRepo.findAll());
        return "screeningList";
    }

    @GetMapping("{screening}")
    public String screeningEditForm(@PathVariable Screening screening, Model model){
        model.addAttribute("screening", screening);
        model.addAttribute("films", filmRepo.findAll());
        model.addAttribute("halls", hallRepo.findAll());
        model.addAttribute("time", screening.getScreeningDateTime().toLocalTime());
        model.addAttribute("date", screening.getScreeningDateTime().toLocalDate());

        return "screeningEdit";
    }

    @GetMapping("/add")
    public String addScreeningPage(Model model){
        model.addAttribute("films", filmRepo.findAll());
        model.addAttribute("halls", hallRepo.findAll());
        return "addScreening";
    }

    @PostMapping("/add")
    public String addScreening(@RequestParam Film film,
                               @RequestParam Hall hall,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime screeningTime,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate screeningDate){
        Screening screening = new Screening();

        screening.setFilm(film);
        screening.setHall(hall);
        LocalDateTime localDateTime = LocalDateTime.of(screeningDate, screeningTime);
        screening.setScreeningDateTime(localDateTime);
        screening.setScreeningDateTime(localDateTime);

        screeningRepo.save(screening);

        return "redirect:/screenings";
    }

    @GetMapping("/delete/{screening}")
    public String screeningDelete(@PathVariable Screening screening){
        screeningRepo.deleteById(screening.getId());
        return "redirect:/screenings";
    }

    @PostMapping
    public String screeningSave(@RequestParam Film film,
                                @RequestParam Hall hall,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime screeningTime,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate screeningDate,
                                @RequestParam("screeningId") Screening screening){

        screening.setFilm(film);
        screening.setHall(hall);
        LocalDateTime localDateTime = LocalDateTime.of(screeningDate, screeningTime);
        screening.setScreeningDateTime(localDateTime);

        screeningRepo.save(screening);

        return "redirect:/screenings";
    }
}

