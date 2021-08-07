package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventsController {

    @RequestMapping("/events")
    public ModelAndView eventsList() {
        String eventsList = "Events list";

        return  new ModelAndView("events", "message", eventsList);
    }

}
