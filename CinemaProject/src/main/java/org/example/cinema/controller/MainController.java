package org.example.cinema.controller;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Screening;
import org.example.cinema.repos.FilmRepo;
import org.example.cinema.repos.HallRepo;
import org.example.cinema.repos.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Comparator;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private ScreeningRepo screeningRepo;

    @Autowired
    private HallRepo hallRepo;

    @GetMapping("/")
    public String greeting(Model model) {
        List<Screening> screeningList = screeningRepo.findAll();
        screeningList.sort(new Comparator<Screening>() {
            @Override
            public int compare(Screening o1, Screening o2) {
                return o1.getScreeningDateTime().compareTo(o2.getScreeningDateTime());
            }
        });
        model.addAttribute("screenings", screeningList);
        return "greeting";
    }

    @GetMapping("{film}/{screening}")
    public String getFilmPage(@PathVariable Film film, @PathVariable Screening screening, Model model){
        model.addAttribute("film", film);
        model.addAttribute("screening", screening);
        return "filmInfo";
    }

    @GetMapping("/main")
    public String main(){
            return "main";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value="error", required = false) String error,
                           @RequestParam(value="logout", required = false) String logout,
                           Model model){
        model.addAttribute("error", error!=null);
        model.addAttribute("logout", logout!=null);
        return "login";
    }
}