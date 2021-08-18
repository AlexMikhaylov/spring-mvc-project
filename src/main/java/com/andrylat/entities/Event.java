package com.andrylat.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

//могут возникнуть проблемы с сериалиацией.
@Data
@Entity(name="events")
public class Event {

    private final String DATE_PATTERN = "dd.MM.yyyy";

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    
    private String name;

    //повторяется формат
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
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
            return this.localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

}
