package br.com.ceducarneiro.exerciciofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"modified, authorsStr"})
public class Book extends SugarRecord {

    @JsonProperty(value = "id")
    private Long guid;
    private String title;
    private String description;
    private List<Long> authors;
    private Long publisher;
    private boolean modified;
    private String authorsStr;

    public Book() {
        authors = new ArrayList<>();
    }

    public static List<Book> findAllModified() {
        return Book.find(Book.class, "modified = ?", "1");
    }

    public static Book findByGuid(Long guid) {
        List<Book> books = Book.find(Book.class, "guid= ?", String.valueOf(guid));
        return books.isEmpty() ? null : books.get(0);
    }

    public void setAuthorsStr(String authorsStr) {
        this.authorsStr = authorsStr;
    }

    public String getAuthorsStr() {
        return authorsStr;
    }

    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getAuthors() {
        if (authors.isEmpty() && authorsStr != null) {
            for (String authorSplit : authorsStr.split(",")) {
                try {
                    authors.add(Long.parseLong(authorSplit));
                } catch (NumberFormatException ignored) {
                    /* Empty */
                }
            }
        }

        return authors;
    }

    public void setAuthors(List<Long> authors) {
        this.authors = authors;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return title;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }
}
