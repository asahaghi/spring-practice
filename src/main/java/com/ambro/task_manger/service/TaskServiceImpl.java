package com.ambro.task_manger.service;

import com.ambro.task_manger.dao.TaskRepository;
import com.ambro.task_manger.entity.Task;
import com.ambro.task_manger.rest.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(int id) {
        Optional<Task> result = taskRepository.findById(id);
        Task task = null;
        if (result.isPresent()) {
            task = result.get();
        }
        else{
            throw new TaskNotFoundException("Task " + id + " not found");
        }
        return task;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }
}
