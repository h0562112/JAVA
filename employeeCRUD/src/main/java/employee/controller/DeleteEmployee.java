package employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.service.EmployeeService;
import employee.service.impl.EmployeeServiceImpl;

@WebServlet("/employee/EmployeeDelete.do")
public class DeleteEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hsession = request.getSession();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.deleteById(id);
		hsession.setAttribute("DeleteSuccess", "刪除成功");
		String url = request.getContextPath() + "/employee/queryEmployee.do";
		String newurl = response.encodeRedirectURL(url);
		response.sendRedirect(newurl);
	}

}
