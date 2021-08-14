package com.example.controllers;

import com.example.entity.Event;
import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventsRestController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/eventsJson", produces = "application/json")
    public List<Event> getEventsJsonList() {

        Event event = eventService.createNewEvent();

        List<Event> events = new ArrayList<>();
        events.add(event);
        events.add(new Event("Event2"));
        events.add(new Event("Event3"));

        return events;
    }

}
