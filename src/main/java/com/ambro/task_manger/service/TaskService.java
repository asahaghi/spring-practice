package com.ambro.task_manger.service;

import com.ambro.task_manger.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(int id);
    Task save(Task task);
    void deleteById(int id);
    Page<Task> findAll(Pageable pageable);
}
