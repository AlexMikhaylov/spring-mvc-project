package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Data
@Entity(name="events")
public class Event {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate localDate;

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

    public String convertLocalDateToString(LocalDate localDate){
        if(localDate != null){
            return this.localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        return "";
    }

}
