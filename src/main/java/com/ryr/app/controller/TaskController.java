package com.ryr.app.controller;

import com.ryr.app.dto.TaskRequestDto;
import com.ryr.app.dto.TaskResponseDto;
import com.ryr.app.entity.Status;
import com.ryr.app.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name= "Tasks",description = "Manage Tasks")//for swagger
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service){
        this.service=service;
    }
    @Operation(summary = "Create Task")
    @PostMapping
    public TaskResponseDto create(@RequestBody TaskRequestDto dto){
        return service.create(dto);
    }
    @Operation(summary = "Get All Tasks")
    @GetMapping
    public List<TaskResponseDto> getAll(){
        return service.getAll();
    }
    @Operation(summary = "Get Task By Id")
    @GetMapping("/{id}")
    public TaskResponseDto getById(@PathVariable Long id){
        return service.getById(id);
    }
    @Operation(summary = "Update Task")
    @PutMapping("/{id}")
    public TaskResponseDto update (@PathVariable Long id, @RequestBody TaskRequestDto dto){
        return service.update(id,dto);
    }
    @Operation(summary = "Delete Task by Id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
    @Operation(summary = "Update Task Status ")
    @PatchMapping("/{id}/status")
    public TaskResponseDto updateStatus(
            @PathVariable Long id,
            @RequestParam Status status
    ) {
        return service.updateStatus(id, status);
    }

}
