package com.ryr.app.dto;

import com.ryr.app.entity.Status;

public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Status status;

    //default constructor
    //Пустой конструктор в Response DTO нужен для сериализации/десериализации JSON
    // (Jackson создаёт объект через него). В Request DTO он не обязателен,
    // если объекты создаются напрямую через конструктор с параметрами.
    public TaskResponseDto(){

    }
    //constructor with args
    public TaskResponseDto(Long id, String title, String description, Status status){
        this.id= id;
        this.title=title;
        this.description=description;
        this.status=status;
    }
//______________________________________________________
    //getters
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
    //_______________________________________________
    //setters
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
