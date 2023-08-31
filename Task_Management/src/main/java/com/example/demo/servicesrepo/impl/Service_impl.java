package com.example.demo.servicesrepo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.Taskrepo;
import com.example.demo.entity.Task;
import com.example.demo.servicesrepo.Service_Repo;

@Service
public class Service_impl implements Service_Repo{
	@Autowired
	private Taskrepo trepo;

	@Override
	public Task addTask(Task t1) {
		Task t=trepo.save(t1);
		return t;
	}

	@Override
	public Task getTask(String id) {
		Task t=null;
		Optional<Task> x=trepo.findById(id);
		if(x.isEmpty()) {
			t=null;
		}
		else {
			t=x.get();
		}
		return t;
		
	}

	@Override
	public List<Task> getAllTask() {
		List<Task> tasks=trepo.findAll();
		return tasks;
	}

	@Override
	public String deleteTask(String id) {
		trepo.deleteById(id);
		String str="Task deleted";
		return str;
	}

	@Override
	public Task updateTask( Task t2) {
		String id=t2.getId();
		Task t;
		if(trepo.existsById(id)) {
		    t=trepo.save(t2);
		}
		else {
			t=trepo.save(t2);
		}
		return t;
	}

}
