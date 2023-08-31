package com.example.demo.servicesrepo;

import java.util.List;

import com.example.demo.entity.Task;

public interface Service_Repo {
	public Task addTask(Task t1);
	public Task getTask(String id);
	public List<Task> getAllTask();
	public String deleteTask(String id);
	public Task updateTask(Task t2);

}
