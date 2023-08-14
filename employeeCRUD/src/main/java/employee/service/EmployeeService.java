package employee.service;

import java.util.List;

import employee.model.Employee;

public interface EmployeeService {
	void resetEmployeeTable();
	void save(Employee employee);
	void update(Employee employee);
	
	Employee findByEmployeeId(String employeeId);
	
	boolean existsByEmployeeId(String employeeId);
	
	Employee findById(Integer id);
	List<Employee> findAll();
	
	void deleteById(Integer id);
}
