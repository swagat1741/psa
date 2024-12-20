package com.crm.crm.controller;

import com.crm.crm.entity.Employee;
import com.crm.crm.payload.EmployeeDto;
import com.crm.crm.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

private EmployeeService employeeService;
//create constructor base dependeancy injection
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping("/add")
public ResponseEntity<?> addEmployee(@Valid@RequestBody EmployeeDto dto,BindingResult result) {
    	if(result.hasErrors()) {
    		return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
       EmployeeDto employee = employeeService.addEmployee(dto);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);

}
@DeleteMapping
    public String deleteEmp(@RequestParam long id){
        employeeService.deleteEmp(id);

        return "deleted";

}
@GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmp(
    		@RequestParam(name = "pageSize",required=false,defaultValue = "3") int pageSize,
    		@RequestParam(name = "pageNo",required=false,defaultValue = "0") int pageNo,
    		@RequestParam(name = "sortBy",required=false,defaultValue = "name") String sortBy,
    		@RequestParam(name = "sortDir",required=false,defaultValue = "asc") String sortDir
    		){
  List<EmployeeDto> emp = employeeService.getEmp(pageSize,pageNo,sortBy,sortDir);
    return new ResponseEntity<>(emp, HttpStatus.OK);

}

@PutMapping
public ResponseEntity<EmployeeDto> updateEmp(@RequestParam long id,@RequestBody EmployeeDto dto) {
EmployeeDto updateEmp = employeeService.updateEmp(id,dto);
return new ResponseEntity<>(updateEmp,HttpStatus.OK);
}
@GetMapping("/employeeId/{id}")
public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id){
	EmployeeDto dto = employeeService.getEmployeeById(id);
	return new ResponseEntity<>(dto,HttpStatus.OK);
	
}

}
