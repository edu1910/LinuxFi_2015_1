package br.com.ceducarneiro.exerciciofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orm.SugarRecord;

import java.util.List;

@JsonIgnoreProperties(value = {"modified"})
public class Author extends SugarRecord {

    @JsonProperty(value = "id")
    private Long guid;
    private String name;
    private boolean modified;

    public static List<Author> findAllModified() {
        return Author.find(Author.class, "modified = ?", Boolean.TRUE.toString());
    }

    public static Author findByGuid(Long guid) {
        List<Author> authors = Author.find(Author.class, "guid= ?", String.valueOf(guid));
        return authors.isEmpty() ? null : authors.get(0);
    }

    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }
}
