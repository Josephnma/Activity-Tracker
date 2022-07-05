package com.example.activity_tracker.service.impl;

import com.example.activity_tracker.dto.requests.TaskEditDTO;
import com.example.activity_tracker.enums.Status;
import com.example.activity_tracker.model.Task;
import com.example.activity_tracker.model.User;
import com.example.activity_tracker.repository.TaskRepository;
import com.example.activity_tracker.repository.UserRepository;
import com.example.activity_tracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public List<Task> retrieveUserTasks() {
        return null;
    }

    @Override
    public Task createTask(TaskEditDTO task) {

       User user = getLoggedInUser();

        Task createdTask = Task.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .status(Status.DONE)
                .user(user)
                .completedDate(task.getCompletedDate())
                .modifiedDate(task.getModifiedDate())
                .build();

        return taskRepository.save(createdTask);
    }


    @Override
    public Task editTask(Long id, TaskEditDTO task) {

        return null;
    }

    @Override
    public Task deleteTask(Long id) {
        return null;
    }

    private User getLoggedInUser(){
       return userRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException("user not found"));
    }
}
