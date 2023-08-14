package employee.service.impl;

import java.util.List;

import employee.model.Employee;
import employee.repository.EmployeeDao;
import employee.repository.impl.EmployeeDaoImpl;
import employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		this.employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public void resetEmployeeTable() {
		employeeDao.resetEmployeeTable();
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public Employee findByEmployeeId(String employeeId) {
		return employeeDao.findByEmployeeId(employeeId);
	}

	@Override
	public Employee findById(Integer id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		employeeDao.deleteById(id);
	}

	@Override
	public boolean existsByEmployeeId(String employeeId) {
		return findByEmployeeId(employeeId) != null ? true : false;
	}

}
