package employee.controller;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.constant.SystemService;
import employee.model.Employee;
import employee.service.EmployeeService;
import employee.service.impl.EmployeeServiceImpl;

@WebServlet("/employee/insertEmployee.do")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 employeeId 欄位內的資料，注意大小寫
		String employeeId = request.getParameter("employeeId");
		// 檢查使用者所輸入的資料
		if (employeeId == null || employeeId.trim().length() == 0) {
			errorMessage.put("employeeId", "員工編號欄必須輸入");
		}
		
		// 讀取使用者所輸入，由瀏覽器送來的 name 欄位內的資料
		String name = request.getParameter("name");
		// 檢查使用者所輸入的資料
		if (name == null || name.trim().length() == 0) {
			errorMessage.put("name", "姓名欄必須輸入");
		}
		
		// 讀取使用者所輸入，由瀏覽器送來的 email 欄位內的資料，注意大小寫
		String email = request.getParameter("email");
		// 檢查使用者所輸入的資料
		if (email == null || email.trim().length() == 0) {
			errorMessage.put("email", "電子郵件欄必須輸入");
		} else if (!SystemService.isValidEmailAddress(email)) {
			errorMessage.put("email", "電子郵件格式錯誤");
		}
		
		// 讀取使用者所輸入，由瀏覽器送來的 birthday 欄位內的資料
		String birthday = request.getParameter("birthday");
		java.sql.Date date = null;
		if (birthday == null) {
			errorMessage.put("birthday", "生日欄必須輸入");
		} else  {
			try {
				date = SystemService.toSqlDate(birthday);
			} catch (Exception e) {
				errorMessage.put("birthday", "生日欄格式錯誤");
			}
		}
		Timestamp ts = new Timestamp(System.currentTimeMillis());
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
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/employee/InsertEmployeeForm.jsp");
			rd.forward(request, response);
			return;
		}
		// Employee 扮演封裝輸入資料的角色
		Employee mb = new Employee(null, employeeId, name, date, email, picture, ts);
		try {
			EmployeeService employeeService = new EmployeeServiceImpl();
			if (employeeService.existsByEmployeeId(employeeId)) {
				throw new RuntimeException("員工編號重複，請修改員工編號");
			}
			employeeService.save(mb);
			request.setAttribute("employee", mb);
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request.getRequestDispatcher("/employee/InsertEmployeeSuccess.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (e.getMessage().indexOf("Cannot create PoolableConnectionFactory") != -1) {
				errorMessage.put("employeeId", "請確認資料庫是否已經開啟");
			} else {
				errorMessage.put("employeeId", e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/employee/InsertEmployeeForm.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage.put("employeeId", "資料庫存取錯誤:" + e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/employee/InsertEmployeeForm.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
