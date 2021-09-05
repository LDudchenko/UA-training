package org.example.cinema.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "screening", fetch=FetchType.EAGER)
    private List<Ticket> tickets;

    private Integer numOfFreeSeats;

    private LocalDateTime screeningDateTime;

    private int priceOfTicket;

    public int numOfFreeSeats(){
        numOfFreeSeats = hall.getNumOfRows()*hall.getNumOfSeatsAtRow() - tickets.size();
        return numOfFreeSeats;
    }

    public boolean isBusySeat(int row, int seat){
        for(Ticket ticket : tickets){
            if(ticket.getNumberOfrow() == row && ticket.getSeat() == seat){
                return true;
            }
        }
        return false;
    }

    public boolean chosenPlace(List<Ticket> cart, int row, int seat, Screening screening){
        for(Ticket ticket : cart){
            if(ticket.getScreening().getId().equals(screening.getId())&&ticket.getNumberOfrow() == row && ticket.getSeat() == seat){
                return true;
            }
        }
        return false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalDateTime getScreeningDateTime() {
        return screeningDateTime;
    }

    public void setScreeningDateTime(LocalDateTime screeningDateTime) {
        this.screeningDateTime = screeningDateTime;
    }


    public Integer getNumOfFreeSeats() {
        return numOfFreeSeats;
    }

    public void setNumOfFreeSeats(Integer numOfFreeSeats) {
        this.numOfFreeSeats = numOfFreeSeats;
    }

    public int getPriceOfTicket() {
        return priceOfTicket;
    }

    public void setPriceOfTicket(int priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }
}
