package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Data
@Entity(name="events")
public class Event {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate localDate;

    @ManyToMany
    private Set<Participant> participants;

    public Event() {
        super();
    }

    public Event(String name) {
        super();
        this.name = name;
    }

    public Event(String name, LocalDate localDate) {
        super();
        this.name = name;
        this.localDate = localDate;
    }

    public Event(Long id, String name, LocalDate localDate, Set<Participant> participants) {
        this.id = id;
        this.name = name;
        this.localDate = localDate;
        this.participants = participants;
    }

    public String convertLocalDateToString(LocalDate localDate){
        if(localDate != null){
            return this.localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        return "";
    }

}
