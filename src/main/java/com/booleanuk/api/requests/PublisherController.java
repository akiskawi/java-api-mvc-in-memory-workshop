package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("publishers")
public class PublisherController {

    private PublisherRepository thePublishers;
    public PublisherController() {
        this.thePublishers = new PublisherRepository();
    }


    @GetMapping
    public ArrayList<Publisher> getAll() {
        return this.thePublishers.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable Integer id) {
        Publisher publisher = this.thePublishers.getOne(id);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return publisher;
    }
    @PostMapping
    public Publisher createOne(@RequestBody Publisher newPublisher){
        return this.thePublishers.createOne(newPublisher);
    }
    @DeleteMapping("/{id}")
    public Publisher deleteOne(@PathVariable Integer id){
        Publisher deletedPublisher =this.thePublishers.deleteOne(id);
        if (deletedPublisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return deletedPublisher;
    }
    @PutMapping("/{id}")
    public Publisher updateOne(@PathVariable Integer id,@RequestBody  Publisher publisher){
        Publisher updatedPublisher = this.thePublishers.updateOne(id,publisher);
        if (updatedPublisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return updatedPublisher;
    }

}

