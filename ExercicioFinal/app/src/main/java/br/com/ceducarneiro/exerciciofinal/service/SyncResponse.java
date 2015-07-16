package br.com.ceducarneiro.exerciciofinal.service;

import java.util.List;

import br.com.ceducarneiro.exerciciofinal.model.Author;
import br.com.ceducarneiro.exerciciofinal.model.Book;
import br.com.ceducarneiro.exerciciofinal.model.Publisher;

public class SyncResponse {

    private List<Author> authors;
    private List<Publisher> publishers;
    private List<Book> books;
    private String serverDate;

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

    public String getServerDate() {
        return serverDate;
    }

    public void setServerDate(String serverDate) {
        this.serverDate = serverDate;
    }
}
