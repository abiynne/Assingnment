package assignment_java_Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import assignment_java_Springboot.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
