package com.andrylat.amikhaylov.service;

import com.andrylat.amikhaylov.entities.Event;
import com.andrylat.amikhaylov.repository.EventRepository;
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
