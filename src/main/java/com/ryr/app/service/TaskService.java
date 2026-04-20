package com.ryr.app.service;

import com.ryr.app.dto.TaskRequestDto;
import com.ryr.app.dto.TaskResponseDto;
import com.ryr.app.entity.Status;
import com.ryr.app.entity.Task;

import java.util.List;


public interface TaskService {
    TaskResponseDto create(TaskRequestDto dto);
    List<TaskResponseDto> getAll();
    TaskResponseDto getById(Long id);
    TaskResponseDto update(Long id, TaskRequestDto dto);
    TaskResponseDto updateStatus(Long id, Status status );
    void delete(Long id);
}

