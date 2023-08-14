package employee.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.constant.SystemService;
import employee.model.Employee;
import employee.service.EmployeeService;
import employee.service.impl.EmployeeServiceImpl;

@WebServlet("/employeeInit.do")
public class EmployeeInit extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	 Object[][] emps = {
	      {null, "sg001", "吳一男", "1960-5-1", "enan_wu@SquidGame.com", "/images/001.jpg"},  
	      {null, "sg067", "姜曉",   "1985-7-2",  "Jiang_Xiao@outlook.com", "/images/067.jpg"},   
	      {null, "sg101", "張德秀", "1970-10-12", "Dexiu_chang1975@gmail.com", "/images/101.jpg"},  
	      {null, "sg212", "韓美女", "1976-11-2", "korean_beauty1984@outlook.com", "/images/212.jpg"},  
	      {null, "sg218", "曹尚佑", "1985-4-23","CaoShangyou1984@SquidGame.com", "/images/218.jpg"},  
	      {null, "sg456", "成奇勳", "1982-6-8","ChengQixun1980@gmail.com", "/images/456.jpg"}
	};

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		EmployeeService employeeService = new EmployeeServiceImpl();
		for(Object[] oa : emps) {
			String employeeId = (String)oa[1];
			String name = (String)oa[2];
			Date birthday = Date.valueOf((String)oa[3]);
			String email = (String)oa[4];
			String filename = (String)oa[5];
			File file = new File(context.getRealPath(filename));
			String mimeType = context.getMimeType(filename);
			String dataUri = "data:" + mimeType + ";base64," +  SystemService.fileToBase64(file);
			Clob clob = null;
			try {
				clob = SystemService.stringToClob(dataUri);
			} catch(SQLException e) {
				throw new ServletException(e);
			}
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			Employee employee = new Employee(null, employeeId, name, birthday, email, clob, ts);
			employeeService.save(employee);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/employee/queryEmployee.do");
		rd.forward(request, response);
		return;
		

	}
	
}
