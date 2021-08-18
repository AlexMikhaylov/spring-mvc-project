package com.andrylat.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name="participants")
public class Participant {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private String firstname;

    private String lastname;

    @ManyToMany
    private Set<Event> events;
    public Participant() {
        super();
    }

    public Participant(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Participant(String firstname, String lastname, Set<Event> events) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.events = events;
    }
}
