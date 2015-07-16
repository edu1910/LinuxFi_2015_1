package br.com.ceducarneiro.exerciciofinal.service;

import java.util.List;

import br.com.ceducarneiro.exerciciofinal.model.Author;
import br.com.ceducarneiro.exerciciofinal.model.Book;
import br.com.ceducarneiro.exerciciofinal.model.Publisher;

public class SyncRequest {

    private List<Author> authors;
    private List<Publisher> publishers;
    private List<Book> books;
    private String lastSyncDate;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(String lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }
}
