package com.example.EmployeeManagementSystemUsingAPIGateWay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // GET API to fetch all employees
    @GetMapping("/getAllEmploy")
    public ResponseEntity<List<Employee>> getAllEmployees() {
    	System.out.println("getting all the Emplyees Using getAllEmployee Methods : =");
        List<Employee> employees = employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);  // Status 200
    }
    
    
//    to get ALl EMployee Data in JSON And XML format 
    
    
    @GetMapping(produces = {"application/json","application/xml"})
    public ResponseEntity<List<Employee>> getAllEmployeeDataUsingJSONOrXML(){
    	System.out.println("getting All the Data In JSON Or XML format ");
    	List<Employee> listOfEmployee = employeeRepository.findAll();
    	return new ResponseEntity<>(listOfEmployee,HttpStatus.OK);
    }
    
    
//    Creating the new Employee 
    @PostMapping("/addNewEmployee")
    public ResponseEntity<Employee> addNewEmployeeToDatabase(@RequestBody Employee employee){
    	Employee savedEmployeeToDB = employeeRepository.save(employee);
    	return new ResponseEntity<Employee>(savedEmployeeToDB,HttpStatus.CREATED);
    	
    }
    
//    Search By Id To get the Single Employee from the database 
    
    @GetMapping("/getEmployeeByUsingID/{id}")
    public ResponseEntity<Employee> getEmployeeByUsingId(@PathVariable Long id){
    	Optional<Employee> employee = employeeRepository.findById(id);
    	System.out.println("The Employee Search is going on please check And Let me Know if Any Futher ");
    	return employee.map(ResponseEntity::ok)
    			.orElseGet(()->ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
//    Search Employee by name
    @GetMapping("/search/by-name")
    public ResponseEntity<List<Employee>> searchByName(@RequestParam String name) {
        List<Employee> employees = employeeRepository.findByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    
//    Finding the Employee using Positions 
    @GetMapping("/searchEmployeeByPosition")
    public ResponseEntity<List<Employee>> searchEmployeeUsingPosition(@RequestParam String position){
    	List<Employee> listOfEmployeeUsingPosition = employeeRepository.findByPosition(position);
    	return new ResponseEntity<>(listOfEmployeeUsingPosition,HttpStatus.OK);
    }
    
//    Finding the  employees containing part of the name
    @GetMapping("/search/by-name-keyword")
    public ResponseEntity<List<Employee>> searchByNameKeyword(@RequestParam String keyword) {
        List<Employee> employees = employeeRepository.searchByNameContaining(keyword);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
//    Updating the Employee data 
    @PutMapping("/updatingTheEmployeeData/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
    	Optional<Employee> findingtheEmployeeusingId = employeeRepository.findById(id);
    	if(!findingtheEmployeeusingId.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}else {
    		Employee employeeData = findingtheEmployeeusingId.get();
    		employeeData.setName(employee.getName());
    		employeeData.setPosition(employee.getPosition());
    		Employee updatedEmployData = employeeRepository.save(employeeData);
    		return ResponseEntity.ok(updatedEmployData);
    	}
    	
    }
    
//    Delete An Employee using id 
    @GetMapping("/deleteByUsingId/{id}")
    public ResponseEntity<Employee> deleteSingleEmployeeUsingId(@PathVariable Long id){
    	Optional<Employee> findEmployeeUsingId = employeeRepository.findById(id);
    	if(!findEmployeeUsingId.isPresent()) {
    		return ResponseEntity.notFound().build();
    	}else {
    		employeeRepository.deleteById(id);
    		return ResponseEntity.noContent().build();
    	}
    }
    
//    Adding the New Employee With validations 
    
//    / Add a new employee
    @PostMapping("/addNewEmployeeWithValidation")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    
    
//    Creating the Response 
    
    @PostMapping("/creatingtheNewResource")
    public ResponseEntity<?> createResource(@Valid	@RequestBody Employee employee ,  BindingResult result){
		System.out.println("calling the Create Resouce method Started Here ");
		if(result.hasFieldErrors()) {
			Map<String,String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		}else {
			Employee savedNewEmployeeWithResource = employeeRepository.save(employee);
			return new ResponseEntity<>("Resource Created for This New Employee Okay ",HttpStatus.CREATED);
		}
    	
		
    	
    }
    
    
    
    
   
}
