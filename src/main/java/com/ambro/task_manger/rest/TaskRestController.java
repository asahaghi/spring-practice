package com.ambro.task_manger.rest;

import com.ambro.task_manger.dao.TaskRepository;
import com.ambro.task_manger.entity.Task;
import com.ambro.task_manger.service.TaskService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TaskRestController {
    private TaskService taskService;
    @PersistenceContext
    private EntityManager entityManager;

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
        /*if (theTask == null) {
            throw new TaskNotFoundException("Task "+ taskId+" not found");
        }*/
        return theTask;
    }

    @PostMapping("/tasks")
    public Task save(@Valid @RequestBody Task task) {
        task.setId(0);
        Task dbTask = taskService.save(task);
        return dbTask;
    }

    @PutMapping("/tasks")
    public Task update(@Valid @RequestBody Task task) {
        Task dbTask = taskService.save(task);
        return dbTask;
    }

    @DeleteMapping("/tasks/{taskId}")
    public String delete(@PathVariable int taskId) {
        Task task = taskService.findById(taskId);
        /*if (task == null) {
            throw new TaskNotFoundException("Task "+ taskId+" not found");
        }*/
        taskService.deleteById(taskId);
        return "Task deleted" + taskId;
    }

    @GetMapping("/tasks/status/{status}")
    public List<Task> findTasksStatus(@PathVariable Task.Status status) {
        TypedQuery<Task> query = entityManager.createQuery
        (
                "SELECT t FROM Task t where t.status = :status", Task.class
        );
        query.setParameter("status", status);
        return query.getResultList();


    }

    @GetMapping("/tasks/search")
    public List<Task> findByTitle(@RequestParam String title) {
        TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t where t.title like concat('%', :title,'%') ", Task.class
        );
        query.setParameter("title", title);
        return query.getResultList();
    }


    @GetMapping("/tasks/page")
    public Page<Task> findAll(Pageable pageable) {
        return taskService.findAll(pageable);
    }
}