package com.example.SpringFirstProjectWithJSPPagesWithNormalPages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.model.TTasks;
import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.repository.ITasksRepository;


@Service
@Transactional
public class TaskService {

	private final ITasksRepository repo;

	public TaskService(ITasksRepository repo) {
		
		this.repo = repo;
	}
	public List<TTasks>	findAll(){
		List<TTasks> tasks = new ArrayList<>();
		
		for (TTasks tTask : repo.findAll()) {
			tasks.add(tTask);
		}
		return tasks;
	}
	public TTasks save(TTasks task){
		return repo.save(task);
		
	}
	public void delete(Integer id){
		repo.deleteById(id);
	}
	public Optional<TTasks> findById(Integer id){
		return repo.findById(id);
	}
	
}