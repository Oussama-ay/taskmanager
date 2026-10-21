package com.example.taskmanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Setter 
@Getter 
public class Task {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    String title;    
    boolean completed;

    protected Task() {}

    public Task(String title, boolean completed)
    {
        this.title = title;
        this.completed = completed;
    }
}
