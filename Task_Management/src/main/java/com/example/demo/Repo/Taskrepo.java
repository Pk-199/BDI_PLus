package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;

public interface Taskrepo extends JpaRepository<Task,String> {

}
