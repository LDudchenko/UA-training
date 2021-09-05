package org.example.cinema.domain;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int numOfRows;
    private int numOfSeatsAtRow;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.REMOVE)
    private List<Screening> screening;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getNumOfSeatsAtRow() {
        return numOfSeatsAtRow;
    }

    public void setNumOfSeatsAtRow(int numOfSeatsAtRow) {
        this.numOfSeatsAtRow = numOfSeatsAtRow;
    }

    public List<Screening> getScreening() {
        return screening;
    }

    public void setScreening(List<Screening> screening) {
        this.screening = screening;
    }
}
