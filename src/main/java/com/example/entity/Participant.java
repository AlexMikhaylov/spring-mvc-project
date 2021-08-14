package com.example.entity;

import java.util.List;

public class Participant {

    private String firstname;
    private String lastname;
    private List<Event> events;

    public Participant() {
    }

    public Participant(String firstname, String lastname, List<Event> events) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.events = events;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
