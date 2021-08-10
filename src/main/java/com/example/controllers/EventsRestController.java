package com.example.controllers;

import com.example.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventsRestController {

    private Event event;

    @GetMapping("/eventsJson")
    @ResponseBody
    public Event eventsJsonList(HttpServletResponse response) {
        response.setContentType("application/json");
        event.setName("event 1");
        return event;
    }

}
