package com.elkhiari.tasks.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository ;

    @Autowired
    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    public void createTask(Task task) {
        if (task == null || task.getTitle() == null) {
            throw new IllegalStateException("Task details are missing.");
        } else if (taskRepository.existsByTitle(task.getTitle())) {
            throw new IllegalStateException("Task already exists.");
        }
        else {
            taskRepository.save(task);
        }
    }
}
