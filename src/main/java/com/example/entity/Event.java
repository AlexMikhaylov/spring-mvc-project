package com.example.entity;

import java.time.LocalDate;
import java.util.List;

public class Event {
    
    private String name;
    private LocalDate eventDate = LocalDate.now();
    private List<Participant> participants;

    public Event() {
        super();
    }

    public Event(String name, LocalDate eventDate, List<Participant> participants) {
        super();
        this.name = name;
        this.eventDate = eventDate;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
