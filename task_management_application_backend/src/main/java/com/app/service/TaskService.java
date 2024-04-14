package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Task;

public interface TaskService {
	// Interface for TaskService

	// Method to retrieve all tasks
	List<Task> getAllTasks();

	// Method to retrieve a task by its ID
	Optional<Task> getTaskById(Long id);

	// Method to create a new task
	Task createTask(Task task);

	// Method to update an existing task by its ID
	Task updateTask(Long id, Task task);

	// Method to delete a task by its ID
	void deleteTask(Long id);
}
