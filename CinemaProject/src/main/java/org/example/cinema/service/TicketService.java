package org.example.cinema.service;

import org.example.cinema.domain.Film;
import org.example.cinema.domain.Screening;
import org.example.cinema.domain.Ticket;
import org.example.cinema.domain.User;
import org.example.cinema.repos.TicketRepo;
import org.example.cinema.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private UserRepo userRepo;

//    public boolean formTicket(Film film, Screening screening, int r, int s, User user){
//        Ticket ticket = new Ticket();
//        ticket.setNumberOfrow(r);
//        ticket.setSeat(s);
//        ticket.setScreening(screening);
//        ticket.setUser(user);
//        if(user.getAccount()>90){
//            user.setAccount(user.getAccount()-90);
//            userRepo.save(user);
//            ticketRepo.save(ticket);
//            return true;
//        }
//        return false;
//    }

    @Transactional
    public boolean buy(int total, User user, Screening screening, HttpSession session){
        List<Ticket> cart = (List<Ticket>) session.getAttribute("cart");
        if(user.getAccount()<total){
            return false;
        } else {
            for (Ticket ticket : cart) {
                ticket.setUser(user);
                ticketRepo.save(ticket);
            }
            user.setAccount(user.getAccount()-total);
            userRepo.save(user);
            session.removeAttribute("cart");
            return true;
        }
    }

    public boolean createTicketCart(Screening screening, int r, int s, HttpSession session){
        Ticket ticket = new Ticket();
        ticket.setNumberOfrow(r);
        ticket.setSeat(s);
        ticket.setScreening(screening);
        if (session.getAttribute("cart") == null) {
            List<Ticket> cart = new ArrayList<Ticket>();
            cart.add(ticket);
            session.setAttribute("cart", cart);
            return true;

        } else {
            List<Ticket> cart = (List<Ticket>) session.getAttribute("cart");
            if(!exists(ticket, cart)) {
                cart.add(ticket);
                session.setAttribute("cart", cart);
            }
            return false;
        }
    }

    public boolean exists(Ticket newTicket, List<Ticket> cart) {
        for (Ticket ticket: cart) {
            if (ticket.getScreening().getId().equals(newTicket.getScreening().getId())&&ticket.getNumberOfrow()==newTicket.getNumberOfrow()&&ticket.getSeat()==newTicket.getSeat()) {
                return true;
            }
        }
        return false;
    }

    public boolean removeFromCart(Screening screening, int r, int s, HttpSession session){
        List<Ticket> cart = (List<Ticket>) session.getAttribute("cart");
        int count = 0;
        Ticket newticket = new Ticket();
        newticket.setSeat(s);
        newticket.setNumberOfrow(r);
        newticket.setScreening(screening);
        if(exists(newticket, cart)) {
            for (Ticket ticket : cart) {
                if (ticket.getScreening().getId().equals(screening.getId()) && ticket.getNumberOfrow() == r && ticket.getSeat() == s) {
                    break;
                }
                count++;
            }
            cart.remove(count);
            session.setAttribute("cart", cart);
            return true;
        }
        return false;
    }
}
