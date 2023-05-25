package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private AuthorRepository theAuthors;

    public AuthorController() {
        this.theAuthors = new AuthorRepository();
    }

    @GetMapping
    public ArrayList<Author> getAll() {
        return this.theAuthors.getAll();
    }
    @GetMapping("/{id}")
    public Author getOne(@PathVariable Integer id) {
        Author author = this.theAuthors.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return author;
    }
    @PostMapping
    public Author createOne(@RequestBody Author newAuthor){
        return this.theAuthors.createOne(newAuthor);
    }
    @DeleteMapping("/{id}")
    public Author deleteOne(@PathVariable Integer id){
        Author deletedAuthor =this.theAuthors.deleteOne(id);
        if (deletedAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return deletedAuthor;
    }
    @PutMapping("/{id}")
    public Author updateOne(@PathVariable Integer id,@RequestBody  Author author){
        Author updatedAuthor = this.theAuthors.updateOne(id,author);
        if (updatedAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return updatedAuthor;
    }

}