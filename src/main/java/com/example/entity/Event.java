package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Event {
    
    private String name;

    //TODO doesn't work
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate localDate;

    private List<Participant> participants;

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

    public Event(String name, LocalDate localDate, List<Participant> participants) {
        super();
        this.name = name;
        this.localDate = localDate;
        this.participants = participants;
    }
}
