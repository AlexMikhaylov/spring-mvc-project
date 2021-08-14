package com.example.controllers;

import com.example.entity.Event;
import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/eventsJson", method = RequestMethod.GET,headers="Accept=application/json")
    public List eventsJsonList() {
        List<Event> events = new ArrayList<>();
        events.add(eventService.createNewEvent());
        return events;
    }

}
