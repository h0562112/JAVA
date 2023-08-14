package employee.controller;

import java.io.IOException;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.constant.SystemService;
import employee.model.Employee;
import employee.service.EmployeeService;
import employee.service.impl.EmployeeServiceImpl;

@WebServlet("/employee/updateEmployee.do")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession hsession = request.getSession();
		Map<String,String> errorMessage = new HashMap<>();
		hsession.setAttribute("ErrorMsg", errorMessage);
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		EmployeeService employeeService = new EmployeeServiceImpl();
		
//		if(modify.equalsIgnoreCase("DELETE")){
//			employeeService.deleteById(id);
//			hsession.setAttribute("DeleteSuccess", "刪除成功");
//			String url = request.getContextPath() + "/employee/queryEmployee.do";
//			String newurl = response.encodeRedirectURL(url);
//			response.sendRedirect(newurl);
//			
//		}else if(modify.equalsIgnoreCase("UPDATE")){
			
			// 讀取瀏覽器送來的 employeeId 欄位內的資料
			String previous_employeeId = request.getParameter("previous_employeeId").trim();
			String employeeId = request.getParameter("employeeId").trim();
			
			// 檢查使用者所輸入的資料
			if (employeeId == null || employeeId.trim().length() == 0) {
				errorMessage.put("employeeId", "員工編號欄必須輸入");
			}
//			System.out.println( "*" + previous_employeeId + "* previous_employeeId");
//			System.out.println( "*" + employeeId + "* employeeId");
			if (!previous_employeeId.equals(employeeId)) {
	            if (employeeService.findByEmployeeId(employeeId) != null){
	           	   errorMessage.put("employeeId", "員工編號已存在，請更正");
	            }
	        }
			
			// 讀取使用者所輸入，由瀏覽器送來的 name 欄位內的資料
			String name = request.getParameter("name");
			// 檢查使用者所輸入的資料
			if (name == null || name.trim().length() == 0) {
				errorMessage.put("name", "姓名欄必須輸入");
			}
			
			// 讀取使用者所輸入，由瀏覽器送來的 birthday 欄位內的資料
			String birthday = request.getParameter("birthday");
			java.sql.Date date = null;
			if (birthday != null && birthday.trim().length() > 0) {
				try {
					date = SystemService.toSqlDate(birthday);
				} catch (Exception e) {
					errorMessage.put("birthday", "生日欄格式錯誤");
				}
			}
			// 讀取使用者所輸入，由瀏覽器送來的 email 欄位內的資料，注意大小寫
			String email = request.getParameter("email");
			// 檢查使用者所輸入的資料
			if (email == null || email.trim().length() == 0) {
				errorMessage.put("email", "電子郵件欄必須輸入");
			} else if (!SystemService.isValidEmailAddress(email)) {
				errorMessage.put("email", "電子郵件格式錯誤");
			}
			Clob picture = null;
			String pic = request.getParameter("picture");
			if (pic == null || pic.trim().length() == 0) {
				errorMessage.put("picture", "圖片欄必須輸入");
			} else {
				try {
					picture = SystemService.stringToClob(pic);
				} catch(Exception e) {
					errorMessage.put("picture", e.getMessage());
					throw new RuntimeException(e);
				}
			}
			
			if (!errorMessage.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/employee/updateEmployee.jsp");
				rd.forward(request, response);
				return;
			}
			Employee employee = new Employee(id, employeeId, name, date, email, picture);
			employeeService.update(employee);
			hsession.setAttribute("modify", "修改成功");
			String url = request.getContextPath() + "/employee/queryEmployee.do";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
		}
}
