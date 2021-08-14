package com.example.entity;

import lombok.Data;

import java.util.List;

@Data
public class Participant {

    private String firstname;
    private String lastname;
    private List<Event> events;

    public Participant() {
        super();
    }

    public Participant(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Participant(String firstname, String lastname, List<Event> events) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.events = events;
    }
}
