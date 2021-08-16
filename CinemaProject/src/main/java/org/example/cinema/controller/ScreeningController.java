package org.example.cinema.controller;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Hall;
import org.example.cinema.domain.Screening;
import org.example.cinema.repos.FilmRepo;
import org.example.cinema.repos.HallRepo;
import org.example.cinema.repos.ScreeningRepo;
import org.example.cinema.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
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
    private ScreeningService screeningService;

    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private HallRepo hallRepo;

    @GetMapping
    public String screeningList(Model model){
        model.addAttribute("screenings", screeningRepo.findAll());
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "screeningList";
    }

    @GetMapping("{screening}")
    public String screeningEditForm(@PathVariable Screening screening, Model model){
        model.addAttribute("screening", screening);
        model.addAttribute("films", filmRepo.findAll());
        model.addAttribute("halls", hallRepo.findAll());
        model.addAttribute("time", screening.getScreeningDateTime().toLocalTime());
        model.addAttribute("date", screening.getScreeningDateTime().toLocalDate());
        model.addAttribute("startDate", LocalDate.now());
        model.addAttribute("endDate", LocalDate.now().plusDays(7));
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "screeningEdit";
    }

    @GetMapping("attendance/{screening}")
    public String screeningAttendance(@PathVariable Screening screening, Model model){
        model.addAttribute("screening", screening);
        model.addAttribute("film", screening.getFilm());
        model.addAttribute("hall", screening.getHall());
        model.addAttribute("time", screening.getScreeningDateTime().toLocalTime());
        model.addAttribute("date", screening.getScreeningDateTime().toLocalDate());
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "attendance";
    }



    @GetMapping("/add")
    public String addScreeningPage(Model model){
        model.addAttribute("films", filmRepo.findAll());
        model.addAttribute("halls", hallRepo.findAll());
        model.addAttribute("startDate", LocalDate.now());
        model.addAttribute("endDate", LocalDate.now().plusDays(7));
        return "addScreening";
    }

    @PostMapping("/add")
    public String addScreening(@RequestParam Film film,
                               @RequestParam Hall hall,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime screeningTime,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate screeningDate,
                               Model model){
        if(!screeningService.add(film, hall, screeningTime, screeningDate)){
            model.addAttribute("message", "Вже присутній сеанс на цей час!" );
            return "errorTemplate";
        }
        return "redirect:/screenings";
    }

    @GetMapping("/delete/{screening}")
    public String screeningDelete(@PathVariable Screening screening){
        screeningService.delete(screening);
        return "redirect:/screenings";
    }

    @PostMapping
    public String screeningSave(@RequestParam Film film,
                                @RequestParam Hall hall,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime screeningTime,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate screeningDate,
                                @RequestParam("screeningId") Screening screening,
                                Model model){
        if(!screeningService.edit(film, hall, screeningTime, screeningDate, screening)){
            model.addAttribute("message", "Вже присутній сеанс на цей час!" );
            return "errorTemplate";
        }
        return "redirect:/screenings";
    }
}

