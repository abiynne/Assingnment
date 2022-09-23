package assignment_java_Springboot.service;

import java.util.ArrayList;


import java.util.List;
import org.springframework.security.core.userdetails.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import assignment_java_Springboot.model.Employee;
import assignment_java_Springboot.repository.EmployeeRepository;
@Service
public class EmployeeService implements UserDetailsService {
	@Autowired

	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}
	
	

	public void saveEmployee(Employee emp) {

		employeeRepository.save(emp);
	}

	public Employee getEmployeeById(Long id) {

		Employee emp = employeeRepository.getById(id);

		if (emp == null) {
			throw new RuntimeException("Employee not found");
		}
		return emp;
	}

	public String deleteEmployeeById(Long id) {

		Employee emp = employeeRepository.getById(id);

		if (emp == null) {
			throw new RuntimeException("Employee not found");
		}

		employeeRepository.deleteById(id);
		return "Deleted: " + emp.getFirstName() + " " + emp.getLastName();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return new User("admin", "password", new ArrayList<>());
	}
}
