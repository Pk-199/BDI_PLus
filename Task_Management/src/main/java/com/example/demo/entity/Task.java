package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="Task_table")
public class Task {
	@Id
	private String id;
	private String name;
	private int time_period;
}
