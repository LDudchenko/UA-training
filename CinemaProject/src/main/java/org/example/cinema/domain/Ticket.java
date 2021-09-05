package org.example.cinema.domain;

import javax.persistence.*;

@Entity
public class Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;
    private int numberOfrow;
    private int seat;

    @ManyToOne
    @JoinColumn(name="ticket_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public int getNumberOfrow() {
        return numberOfrow;
    }

    public void setNumberOfrow(int numberOfrow) {
        this.numberOfrow = numberOfrow;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
