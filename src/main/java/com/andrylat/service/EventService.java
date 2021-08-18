package com.andrylat.service;

import com.andrylat.entities.Event;
import com.andrylat.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eventService")
public class EventService {

    @Autowired
    public EventRepository eventRepository;

    public Event createNewEvent(){
        return eventRepository.createNewEvent();
    }
}
