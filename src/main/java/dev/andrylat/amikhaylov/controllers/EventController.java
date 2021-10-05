package dev.andrylat.amikhaylov.controllers;

import dev.andrylat.amikhaylov.entities.Event;
import dev.andrylat.amikhaylov.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("eventController")
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ModelAndView getEventsList() {
        Event event = eventService.createNewEvent();

        return  new ModelAndView("events", "message", event);
    }
}
