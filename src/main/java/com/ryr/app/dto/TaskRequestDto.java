package com.ryr.app.dto;

public class TaskRequestDto {
    private String title;
    private String description;
    //Пустой конструктор в Response DTO нужен для сериализации/десериализации JSON
    // (Jackson создаёт объект через него). В Request DTO он не обязателен,
    // если объекты создаются напрямую через конструктор с параметрами.
    public TaskRequestDto(String title, String description){
        this.title = title;
        this.description = description;

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
}
