package com.example.SpringFirstProjectWithJSPPagesWithNormalPages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

	
}
