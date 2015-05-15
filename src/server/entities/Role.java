package server.entities;

import java.io.Serializable;

/**
 * Created by Paul on 02/05/2015.
 */
public class Role implements Serializable{

    private Integer id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}