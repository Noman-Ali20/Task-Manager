package com.gokapture.assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByUserIdAndStatus(Long userId, String status);
    List<Task> findByUserIdAndPriority(Long userId, String priority);
    List<Task> findByUserIdAndDueDate(Long userId, LocalDate dueDate);
}
