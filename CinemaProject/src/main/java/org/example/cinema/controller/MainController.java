package org.example.cinema.controller;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Screening;
import org.example.cinema.domain.User;
import org.example.cinema.repos.TicketRepo;
import org.example.cinema.repos.UserRepo;
import org.example.cinema.service.ScreeningService;
import org.example.cinema.service.TicketService;
import org.example.cinema.service.UserService;
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

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class MainController {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(@PageableDefault Pageable pageable, Model model) {
        screeningService.numOfFreeSeats();
        Page<Screening> page = screeningService.findAllWithScreeningDateTimeAfterByOrderByScreeningDateTime(pageable, LocalDateTime.now());
        String sort = page.getSort().toString();
        if(sort.contains("UNSORTED")) {
            sort="screeningDateTime";
            page = screeningService.findAllWithScreeningDateTimeAfterByOrderByScreeningDateTime(pageable, LocalDateTime.now());
        }else if(sort.contains(":")) {
            sort = page.getSort().toString().substring(0, page.getSort().toString().indexOf(":"));
        }
        model.addAttribute("sort", sort);
        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "greeting";
    }

    @GetMapping("{user}")
    public String getTickets(User user, Model model){
        model.addAttribute("tickets", user.getTickets());
        model.addAttribute("user", user);
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "tickets";
    }

    @GetMapping("{film}/{screening}")
    public String getFilmPage(@PathVariable Film film, @PathVariable Screening screening, Model model){
        model.addAttribute("film", film);
        model.addAttribute("screening", screening);
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "filmInfo";
    }

//    @GetMapping("/{film}/{screening}/{r}/{s}/{user}/buy")
//    public String buy(@PathVariable Film film, @PathVariable Screening screening, @PathVariable int r, @PathVariable int s, @PathVariable User user, Model model){
//        if(ticketService.formTicket(film, screening, r, s,user)){
//            return "redirect:/";
//        } else{
//            model.addAttribute("message", "Недосатньо коштів");
//            return "errorTemplate";
//        }
//    }

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

    @PostMapping("/topUpAnAccount")
    public String topUpAccount(@RequestParam("user") User user, @RequestParam String money, Model model){
        if(Integer.parseInt(money)<20){
            model.addAttribute("message", "Мінімальна сума 20 грн!");
        } else {
            userService.topUpAccount(user, Integer.parseInt(money));
        }
        model.addAttribute("user", user);
        model.addAttribute("tickets", user.getTickets());
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "tickets";
    }

    @GetMapping("/{screening}/{r}/{s}")
    public String buy(@PathVariable Screening screening, @PathVariable int r, @PathVariable int s, /*@PathVariable User user,*/ Model model, HttpSession session) {
        ticketService.createTicketCart(screening, r, s, session);
        model.addAttribute("film", screening.getFilm());
        model.addAttribute("screening", screening);
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "filmInfo";
    }

    @GetMapping(value = "remove/{screening}/{r}/{s}")
    public String remove(@PathVariable Screening screening, @PathVariable int r, @PathVariable int s, HttpSession session, Model model) {
        ticketService.removeFromCart(screening, r, s, session);
        model.addAttribute("film", screening.getFilm());
        model.addAttribute("screening", screening);
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "filmInfo";
    }

    @PostMapping("/buy")
    public String buy1(@RequestParam int total, @RequestParam("user") User user,@RequestParam("screening") Screening screening, HttpSession session, Model model){
        if(ticketService.buy(total, user, screening, session)){
            model.addAttribute("message", "Успішна покупка");
        } else {
            model.addAttribute("message", "Недостатньо коштів");
        }
        model.addAttribute("film", screening.getFilm());
        model.addAttribute("screening", screening);
        model.addAttribute("lci", LocaleContextHolder.getLocale().toString().equals("en"));
        return "filmInfo";
    }

}