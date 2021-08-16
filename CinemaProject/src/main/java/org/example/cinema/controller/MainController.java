package org.example.cinema.controller;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Screening;
import org.example.cinema.domain.Ticket;
import org.example.cinema.repos.FilmRepo;
import org.example.cinema.repos.HallRepo;
import org.example.cinema.repos.ScreeningRepo;
import org.example.cinema.repos.TicketRepo;
import org.example.cinema.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class MainController {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private ScreeningRepo screeningRepo;
    @Autowired
    private HallRepo hallRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private ScreeningService screeningService;

    @GetMapping("/")
    public String greeting(@PageableDefault Pageable pageable, Model model) {
        screeningService.numOfFreeSeats();
        Page<Screening> page = screeningRepo.findAllWithScreeningDateTimeAfterByOrderByScreeningDateTime(pageable, LocalDateTime.now());
        String sort = page.getSort().toString();
        if(sort.contains("UNSORTED")) {
            sort="screeningDateTime";
            page = screeningRepo.findAllWithScreeningDateTimeAfterByOrderByScreeningDateTime(pageable, LocalDateTime.now());
        }else if(sort.contains(":")) {
            sort = page.getSort().toString().substring(0, page.getSort().toString().indexOf(":"));
        }
        model.addAttribute("sort", sort);
        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "greeting";
    }

    @GetMapping("{film}/{screening}")
    public String getFilmPage(@PathVariable Film film, @PathVariable Screening screening, Model model){
        model.addAttribute("film", film);
        model.addAttribute("screening", screening);
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "filmInfo";
    }

    @GetMapping("{film}/{screening}/{r}/{s}")
    public String getFilmPageWithSeat(@PathVariable Film film, @PathVariable Screening screening, @PathVariable int r, @PathVariable int s, Model model){
        model.addAttribute("film", film);
        model.addAttribute("screening", screening);
        model.addAttribute("row", r);
        model.addAttribute("seat", s);
        return "form";
    }

    @PostMapping("/{film}/{screening}/{r}/{s}/buy")
    public String buy(@RequestParam Screening screening, @RequestParam String row, @RequestParam String seat){
        Ticket ticket = new Ticket();
        ticket.setNumberOfrow(Integer.parseInt(row));
        ticket.setSeat(Integer.parseInt(seat));
        ticket.setScreening(screening);
        ticketRepo.save(ticket);
        return "redirect:/";
    }

    @GetMapping("/{film}/{screening}/{r}/{s}/buy")
    public String buy1(@PathVariable Film film, @PathVariable Screening screening, @PathVariable int r, @PathVariable int s){
        Ticket ticket =new Ticket();
        ticket.setNumberOfrow(r);
        ticket.setSeat(s);
        ticket.setScreening(screening);
        ticketRepo.save(ticket);
        return "redirect:/";
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