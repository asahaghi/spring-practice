package com.ambro.task_manger.rest;

import com.ambro.task_manger.dao.TaskRepository;
import com.ambro.task_manger.entity.Task;
import com.ambro.task_manger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private TaskService taskService;
    @Autowired
    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    public Task findById(@PathVariable int taskId) {
        Task theTask = taskService.findById(taskId);
        if (theTask == null) {
            throw new TaskNotFoundException("Task "+ taskId+" not found");
        }
        return theTask;
    }

    @PostMapping("/tasks")
    public Task save(@RequestBody Task task) {
        task.setId(0);
        Task dbTask = taskService.save(task);
        return dbTask;
    }

    @PutMapping("/tasks")
    public Task update(@RequestBody Task task) {
        Task dbTask = taskService.save(task);
        return dbTask;
    }

    @DeleteMapping("/tasks/{taskId}")
    public String delete(@PathVariable int taskId) {
        Task task = taskService.findById(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task "+ taskId+" not found");
        }
        taskService.deleteById(taskId);
        return "Task deleted" + taskId;
    }
}
