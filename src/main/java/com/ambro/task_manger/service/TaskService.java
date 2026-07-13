package com.ambro.task_manger.service;

import com.ambro.task_manger.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(int id);
    Task save(Task task);
    void deleteById(int id);
}
