package com.traider.journal.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.ArrayList;
@Entity
//defining class name as Table name
@Table
public class User {

    @Id
//defining id as column name
    @Column
    private Long id;
    @Column
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
