package br.com.ceducarneiro.exerciciofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orm.SugarRecord;

import java.util.List;

@JsonIgnoreProperties(value = {"modified"})
public class Publisher extends SugarRecord {

    @JsonProperty(value = "id")
    private Long guid;
    private String name;
    private boolean modified;

    public static List<Publisher> findAllModified() {
        return Publisher.find(Publisher.class, "modified = ?", Boolean.TRUE.toString());
    }

    public static Publisher findByGuid(Long guid) {
        List<Publisher> publishers = Publisher.find(Publisher.class, "guid= ?", String.valueOf(guid));
        return publishers.isEmpty() ? null : publishers.get(0);
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
