package com.ryr.app.mapper;
import com.ryr.app.dto.*;
import com.ryr.app.dto.TaskRequestDto;
import com.ryr.app.entity.Status;
import com.ryr.app.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(TaskRequestDto dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(Status.NEW);
        return task;
    }

    public TaskResponseDto toDto(Task task){
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus()
        );
    }
}
