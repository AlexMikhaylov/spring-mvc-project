package dev.andrylat.amikhaylov.repository;

import dev.andrylat.amikhaylov.entities.Event;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository("eventRepository")
public class EventRepository {

    public Event createNewEvent() {
        return new Event(
                "Event1", LocalDate.now()
        );
    }
}
