package com.elkhiari.tasks.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {
    private final TaskService taskService ;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTask() {
        return taskService
                .getTask();
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        Map<String, Object> response = new HashMap<>();
        int code = 201;
        try {
            taskService.createTask(task);
            response.put("message", "created successfully");
        }
        catch (IllegalStateException e) {
            response.put("message", e.getMessage());
            code = 400;
        }
        return ResponseEntity
                .status(code)
                .body(response);
    }
}
