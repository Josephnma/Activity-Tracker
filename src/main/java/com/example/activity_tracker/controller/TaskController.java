package com.example.activity_tracker.controller;

import com.example.activity_tracker.dto.requests.TaskEditDTO;
import com.example.activity_tracker.model.Task;
import com.example.activity_tracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getUserTasks(){
        return ResponseEntity.ok().body(taskService.retrieveUserTasks());
    }

    @PostMapping("/create-task")
    public String createTask(@RequestBody TaskEditDTO task){
        taskService.createTask(task);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
                //.ok().body(taskService.createTask(task));
        return "Task Created";
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Task> editTask(@PathVariable("postId") Long id, TaskEditDTO task){
        return ResponseEntity.ok().body(taskService.editTask(id, task));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Task> deleteTask(@PathVariable("postId") Long id){
        return ResponseEntity.ok().body(taskService.deleteTask(id));
    }
}
