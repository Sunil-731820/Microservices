package com.example.SpringFirstProjectWithJSPPagesWithNormalPages.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.model.TTasks;

public interface ITTaskJpaCrud extends JpaRepository<TTasks, Integer> {

}