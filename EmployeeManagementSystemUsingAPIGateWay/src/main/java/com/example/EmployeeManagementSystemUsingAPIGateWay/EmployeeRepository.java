package com.example.EmployeeManagementSystemUsingAPIGateWay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



	List<Employee> findByName(String name);

	@Query("select e from Employee e where e.position = :position")
	List<Employee> findByPosition(String position);

	 // Method 3: Native SQL Query - Find employees containing part of the name
    @Query(value = "SELECT * FROM employee WHERE name LIKE %:keyword%", nativeQuery = true)
	List<Employee> searchByNameContaining(String keyword);
}

