package com.gokapture.assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task, User user) {
        task.setUser(user);
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUserId(user.getId());
    }

    public Task updateTask(Long taskId, Task taskDetails, User user) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        if (task.getUser().getId().equals(user.getId())) {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            task.setPriority(taskDetails.getPriority());
            task.setDueDate(taskDetails.getDueDate());
            task.setUpdatedAt(LocalDateTime.now());
            return taskRepository.save(task);
        }
        throw new RuntimeException("Unauthorized operation");
    }

    public void deleteTask(Long taskId, User user) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        if (task.getUser().getId().equals(user.getId())) {
            taskRepository.delete(task);
        } else {
            throw new RuntimeException("Unauthorized operation");
        }
    }
}
