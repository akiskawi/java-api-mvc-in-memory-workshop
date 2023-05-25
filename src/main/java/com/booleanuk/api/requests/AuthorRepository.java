package com.booleanuk.api.requests;

import java.util.ArrayList;

public class AuthorRepository {
    private ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("JRR Tolkien", "jrr@tolkien.com"));
        this.authors.add(new Author("Charles Dickens", "charles@bleakhouse.com"));
    }

    public ArrayList<Author> getAll() {
        return this.authors;
    }

    public Author getOne(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }
    public Author deleteOne(int id){
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            if (author.getId() == id) {
                return authors.remove(i);
            }
        }
        return null;
    }
    public Author updateOne(int id,Author updatedAuthor){
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            if (author.getId() == id) {
                authors.get(i).setEmail(updatedAuthor.getEmail());
                authors.get(i).setName(updatedAuthor.getName());
                return authors.get(i);
            }
        }
        return null;
    }
    public Author createOne(Author author){
        authors.add(author);
        return author;
    }
}