package com.booleanuk.api.requests;

import java.util.ArrayList;

public class PublisherRepository {
    private ArrayList<Publisher> publishers;

    public PublisherRepository() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("JRR Tolkien", "Shire"));
        this.publishers.add(new Publisher("Charles Dickens", "London"));
    }

    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }

    public Publisher getOne(int id) {
        for (Publisher publisher : this.publishers) {
            if (publisher.getId() == id) {
                return publisher;
            }
        }
        return null;
    }
    public Publisher deleteOne(int id){
        for (int i = 0; i < publishers.size(); i++) {
            Publisher publisher = publishers.get(i);
            if (publisher.getId() == id) {
                return publishers.remove(i);
            }
        }
        return null;
    }
    public Publisher updateOne(int id,Publisher updatePublisher){
        for (int i = 0; i < publishers.size(); i++) {
            Publisher publisher = publishers.get(i);
            if (publisher.getId() == id) {
                publishers.get(i).setCity(updatePublisher.getCity());
                publishers.get(i).setName(updatePublisher.getName());
                return publishers.get(i);
            }
        }
        return null;
    }
    public Publisher createOne(Publisher publisher){
        publishers.add(publisher);
        return publisher;
    }
}