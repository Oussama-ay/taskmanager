package com.example.taskmanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TaskService {

	private TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository)
	{
		this.taskRepository = taskRepository;
	}

	public List<Task> getAll()
	{
		return taskRepository.findAll();
	}

	public Task getById(Long id)
	{
		return taskRepository.findById(id).orElseThrow(
			() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
		);
	}

	public Task create(TaskRequest request)
	{
		Task task = new Task(request.title(), request.completed());
		return taskRepository.save(task);
	}

	public Task update(TaskRequest request, Long id)
	{
		Task task = getById(id);
		task.setTitle(request.title());
		task.setCompleted(request.completed());
		return taskRepository.save(task);
	}

	public void delete(Long id)
	{
		taskRepository.deleteById(id);
	}
}
