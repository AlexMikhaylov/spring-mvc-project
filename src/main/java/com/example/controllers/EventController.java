package com.example.controllers;

import com.example.entity.Event;
import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("eventController")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public ModelAndView eventsList() {
        Event event = eventService.createNewEvent();
        String eventName = event.getName();

        return  new ModelAndView("events", "message", event);
    }
}