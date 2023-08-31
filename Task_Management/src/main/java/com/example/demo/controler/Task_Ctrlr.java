package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.servicesrepo.Service_Repo;

@RestController
@RequestMapping(value="/task")
public class Task_Ctrlr {
	@Autowired
	private Service_Repo srepo;
	@PostMapping("/add")
	public ResponseEntity<String> createTask(@RequestBody Task t){
		Task T=srepo.addTask(t);
		String message="Task added sucessfully";
		return ResponseEntity.status(HttpStatus.CREATED).body(message);	
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Task> retriveTask(@PathVariable String id){
		Task t=srepo.getTask(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(t);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Task>> retriveAllTask(){
		List<Task> tasks=srepo.getAllTask();
		return ResponseEntity.status(HttpStatus.FOUND).body(tasks);	
	}
	@PutMapping("/update")
	public ResponseEntity<Task> updateTask(@RequestBody Task t2){
		Task t=srepo.updateTask(t2);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(t);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable String id){
		String message=srepo.deleteTask(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);	
	}

}
