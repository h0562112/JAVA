package employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.model.Employee;
import employee.service.EmployeeService;
import employee.service.impl.EmployeeServiceImpl;

@WebServlet("/employee/queryEmployee.do")
public class QueryAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService employeeService = new EmployeeServiceImpl();
		List <Employee> employees = employeeService.findAll();
		request.setAttribute("allEmployees", employees);
		RequestDispatcher rd = request.getRequestDispatcher("/employee/showEmployees.jsp");
		rd.forward(request, response);
		return;		
	}

}
