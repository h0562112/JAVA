package employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.model.Employee;
import employee.service.EmployeeService;
import employee.service.impl.EmployeeServiceImpl;


@WebServlet("/employee/findEmployee.do")
public class FindEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));     //注意大小寫
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee = employeeService.findById(id);
		request.setAttribute("emp", employee);
		RequestDispatcher rd = request.getRequestDispatcher("/employee/updateEmployee.jsp");
		rd.forward(request, response);
		return;
	}
}
