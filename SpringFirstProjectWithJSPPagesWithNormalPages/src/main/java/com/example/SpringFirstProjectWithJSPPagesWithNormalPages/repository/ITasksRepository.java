package com.example.SpringFirstProjectWithJSPPagesWithNormalPages.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.model.TTasks;


public interface ITasksRepository extends CrudRepository<TTasks, Integer>{

}