package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	// JpaRepository interface for Task entity with Long as the ID type
}
