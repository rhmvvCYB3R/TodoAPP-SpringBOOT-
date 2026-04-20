package com.ryr.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
//@GeneratedValue(strategy = GenerationType.IDENTITY) говорит JPA,
// что значение первичного ключа генерирует база данных автоматически (обычно автоинкремент),
// и его не нужно задавать вручную.
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status; //Todo / Done

    public Task(){
        //CONSTRUCTOR
    }

    //Constructor with arguments
    public Task(Long id, String title, String description, Status status){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;

    }
//___________________________________________________________________
    //Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }
    //___________________________________________________________________
    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
