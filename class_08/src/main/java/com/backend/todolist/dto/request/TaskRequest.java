package com.backend.todolist.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TaskRequest {

	// Attributes
	@NotBlank(message = "Informe o título da tarefa")
	private String title;
	@NotBlank(message = "Informe a descrição da tarefa")
	private String description;
	private boolean isDone;
	private LocalDate startDate;
	private LocalDate endDate;

	// Constructors
	public TaskRequest() {
	}

	public TaskRequest(String title, String description, boolean isDone,
		LocalDate startDate, LocalDate endDate) {
		this.title = title;
		this.description = description;
		this.isDone = isDone;
		this.startDate = startDate;
		this.endDate = endDate;
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

	// Setters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
