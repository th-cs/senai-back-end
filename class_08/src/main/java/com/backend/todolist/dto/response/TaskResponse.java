package com.backend.todolist.dto.response;

import com.backend.todolist.entity.Task;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TaskResponse {

	// Attributes
	private String title;
	private String description;
	private boolean isDone;
	private LocalDate startDate;
	private LocalDate endDate;

	// Constructor
	public TaskResponse() {
	}

	public TaskResponse(Task task) {
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.isDone = task.getIsDone();
		this.startDate = task.getStartDate();
		this.endDate = task.getEndDate();
	}

	// Getters
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

}
