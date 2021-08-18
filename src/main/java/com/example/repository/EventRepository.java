package com.example.repository;

import com.example.entities.Event;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository("eventRepository")
public class EventRepository {

    public Event createNewEvent() {
        Event event = new Event(
                "Event1", LocalDate.now()
        );

        return event;

    }
}
