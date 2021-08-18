package com.example.controllers;

import com.example.entities.Event;
import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventsRestController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/eventsJson")
    public List<Event> getEventsJsonList() {

        Event event = eventService.createNewEvent();

        List<Event> events = new ArrayList<>();
        events.add(event);
        events.add(new Event("Event2", LocalDate.now()));
        events.add(new Event("Event3", LocalDate.now()));

        return events;
    }

}
