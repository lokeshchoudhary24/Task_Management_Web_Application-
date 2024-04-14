package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Task;
import com.app.repository.TaskRepository;
import com.app.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	// Method to retrieve all tasks
	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// Method to retrieve a task by its ID
	@Override
	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id);
	}

	// Method to create a new task
	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	// Method to update an existing task by its ID
	@Override
	public Task updateTask(Long id, Task task) {
		task.setId(id);
		return taskRepository.save(task);
	}

	// Method to delete a task by its ID
	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}
