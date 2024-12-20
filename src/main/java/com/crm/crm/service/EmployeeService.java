package com.crm.crm.service;

import com.crm.crm.Exception.ResourceNotFound;
import com.crm.crm.entity.Employee;
import com.crm.crm.payload.EmployeeDto;
import com.crm.crm.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    //dependancy injection using constructor
    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper){
      this.employeeRepository=employeeRepository;
      this.modelMapper=modelMapper;
    }

    public EmployeeDto addEmployee(EmployeeDto dto) {
    	Employee employee = mapToEntity(dto);
        Employee employees = employeeRepository.save(employee);
        EmployeeDto employeeDto = mapToDto(employees);
        employeeDto.setDate(new Date());

        System.out.println("record saved");
        return employeeDto;
    }

    public void deleteEmp(long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeDto> getEmp(int pageSize, int pageNo,String sortBy, String sortDir) {
    	Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
    	Pageable page=PageRequest.of(pageNo, pageSize,sort);
    Page<Employee> all = employeeRepository.findAll(page);
    List<Employee> employee = all.getContent();
        List<EmployeeDto> dto = employee.stream().map(emp->mapToDto(emp)).collect(Collectors.toList());
        System.out.println(dto);
        return dto;
    }

    public EmployeeDto updateEmp(long id, EmployeeDto dto) {

       Employee employee = mapToEntity(dto);
       employee.setId(id);
        
        Employee updatedEmployee = employeeRepository.save(employee);
        EmployeeDto updatedDto = mapToDto(updatedEmployee);
        return updatedDto;
    }
    Employee mapToEntity(EmployeeDto dto){
    	Employee employee = modelMapper.map(dto, Employee .class);
        return employee;

    }
    EmployeeDto mapToDto(Employee employee) {
    	
    
    	EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);
    	
    	
    	return dto;
    	
    }

	public EmployeeDto getEmployeeById(long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFound("records not found with"+id));
		
		EmployeeDto dto = mapToDto(employee);
		return dto;
		// TODO Auto-generated method stub
		
	}
}
