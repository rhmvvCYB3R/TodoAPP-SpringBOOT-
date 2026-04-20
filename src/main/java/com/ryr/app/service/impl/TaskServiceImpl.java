package com.ryr.app.service.impl;

import com.ryr.app.dto.TaskRequestDto;
import com.ryr.app.dto.TaskResponseDto;
import com.ryr.app.entity.Status;
import com.ryr.app.entity.Task;
import com.ryr.app.mapper.TaskMapper;
import com.ryr.app.repo.TaskRepo;
import com.ryr.app.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo repo;
    private final TaskMapper mapper;

    public TaskServiceImpl(TaskRepo repo, TaskMapper mapper){
        this.repo = repo;
        this.mapper = mapper;

    }
    @Override
    public TaskResponseDto create(TaskRequestDto dto){
        Task task = mapper.toEntity(dto);
        return mapper.toDto((repo.save(task)));
    }

    @Override
    public List<TaskResponseDto> getAll(){
        return repo.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto getById(Long id){
        Task task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return mapper.toDto(task);
    }

    @Override
    public TaskResponseDto update(Long id, TaskRequestDto dto){
        Task task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        return  mapper.toDto(repo.save(task));
    }


    public TaskResponseDto updateStatus(Long id, Status status) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);
        return mapper.toDto(repo.save(task));
    }

    @Override
    public void delete(Long id){
        repo.deleteById(id);
    }

}
