package com.backend.todolist.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "tb_task")
public class Task {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column (name = "title", length = 100, nullable = false)
	private String title;
	@Column (name = "description")
	private String description;
	@Column (name = "isDone", nullable = false)
	private boolean isDone;
	@Column (name = "start_date")
	private LocalDate startDate;
	@Column (name = "end_date")
	private LocalDate endDate;

	// Constructors
	public Task() {
	}

	public Task(String title, String description, boolean isDone,
		LocalDate startDate, LocalDate endDate) {
		this.title = title;
		this.description = description;
		this.isDone = isDone;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// Getters
	public long getId() {
		return id;
	}

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
	public void setId(long id) {
		this.id = id;
	}

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
