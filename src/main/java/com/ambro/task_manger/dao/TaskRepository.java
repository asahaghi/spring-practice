package com.ambro.task_manger.dao;

import com.ambro.task_manger.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
