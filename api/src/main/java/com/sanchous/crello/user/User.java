package com.sanchous.crello.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alexandr S. Somov
 * Все права принадлежат автору. За использование без ведома и разрешения автора вам будет стыдно.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    private String id;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
