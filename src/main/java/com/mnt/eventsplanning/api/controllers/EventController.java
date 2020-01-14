package com.mnt.eventsplanning.api.controllers;

import com.mnt.eventsplanning.api.exceptions.ResourceNotFoundException;
import com.mnt.eventsplanning.api.models.Events;
import com.mnt.eventsplanning.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<Events> createEvent(@RequestBody @Valid Events event, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(event, HttpStatus.BAD_REQUEST);
        }
        Events savedEvent = eventRepository.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Events> listEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Events getEvent(@PathVariable("id") Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No event found with id="+id));
    }

    @PutMapping("/{id}")
    public Events putEvent(@PathVariable("id") Long id, @RequestBody Events event) {
        eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No event found with id="+id));

        return eventRepository.save(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        Events event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No event found with id="+id));
        eventRepository.deleteById(event.getId());
    }
}
