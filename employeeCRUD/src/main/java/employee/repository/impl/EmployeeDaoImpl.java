package employee.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import employee.constant.SystemService;
import employee.model.Employee;
import employee.repository.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

	DataSource dataSource;
	
	public EmployeeDaoImpl() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup(SystemService.JNDI_String);
		} catch (NamingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void resetEmployeeTable() {
		String drop_table = "DROP TABLE IF EXISTS employees";

        String create_table = "CREATE TABLE  employees (" + 
            "  `id` INT NOT NULL AUTO_INCREMENT, " + 
            "  `employeeid` VARCHAR(255) NOT NULL, " +
            "  `name`       VARCHAR(255) NOT NULL, " + 
            "  `birthday`   DATETIME  NULL, " + 
            "  `email`      VARCHAR(255) NOT NULL, " + 
            "  `image`      LONGTEXT, " +
            "  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, " +
            "  PRIMARY KEY (`id`) " +
            ");  ";
        
        try (
        	Connection conn = dataSource.getConnection();
			PreparedStatement stmtDrop = conn.prepareStatement(drop_table);
        	PreparedStatement stmtCreate = conn.prepareStatement(create_table);
        ) {
			stmtDrop.executeUpdate();
			stmtCreate.executeUpdate();
			
     	} catch(Exception ex) {
     		throw new RuntimeException(ex);
     		
     	}
	}

	private static final String INSERT = "INSERT INTO employees ( "
			+ " employeeId, name, birthday, email, picture, created_at) "
			+ " VALUES (?, ?, ?, ?, ?, ?)";
	
	@Override
	public void save(Employee employee) {
		try (
			Connection conn = dataSource.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(INSERT);
		) {
			stmt.setString(1, employee.getEmployeeId());
			stmt.setString(2, employee.getName());
			stmt.setDate(3, employee.getBirthday());
			stmt.setString(4, employee.getEmail());
			stmt.setClob(5, employee.getPicture());
			stmt.setTimestamp(6, employee.getCreated_at());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		}

	}

	private static final String UPDATE = "UPDATE employees e "
			+ " SET e.employeeId = ?, e.name = ?, e.birthday = ?, e.email = ?, e.picture = ? "
			+ " WHERE e.id = ?";
	
	@Override
	public void update(Employee employee) {
		try (
			Connection conn = dataSource.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
		) {
			stmt.setString(1, employee.getEmployeeId());
			stmt.setString(2, employee.getName());
			stmt.setDate(3, employee.getBirthday());
			stmt.setString(4, employee.getEmail());
			stmt.setClob(5, employee.getPicture());
			stmt.setInt(6, employee.getId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
	private static final String SELECT_BY_EMPLOYEEID = "SELECT * FROM employees e WHERE e.employeeId = ?";
	@Override
	public Employee findByEmployeeId(String employeeId) {
		Employee result = null;
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_EMPLOYEEID);
		) {
			stmt.setString(1, employeeId);
			try (ResultSet rset = stmt.executeQuery();
			) {
				if (rset.next()) {
					result = new Employee();
					result.setId(rset.getInt("id"));
					result.setEmployeeId(rset.getString("employeeId"));
					result.setName(rset.getString("name"));
					result.setBirthday(rset.getDate("birthday"));
					result.setEmail(rset.getString("email"));
					result.setPicture(rset.getClob("picture"));
					result.setCreated_at(rset.getTimestamp("created_at"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	private static final String SELECT_BY_ID = "SELECT * FROM employees e WHERE e.id = ?";
	@Override
	public Employee findById(Integer id) {
		Employee result = null;
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
		) {
			stmt.setInt(1, id);
			try (ResultSet rset = stmt.executeQuery();
			) {
				if (rset.next()) {
					result = new Employee();
					result.setId(rset.getInt("id"));
					result.setEmployeeId(rset.getString("employeeId"));
					result.setName(rset.getString("name"));
					result.setBirthday(rset.getDate("birthday"));
					result.setEmail(rset.getString("email"));
					result.setPicture(rset.getClob("picture"));
					result.setCreated_at(rset.getTimestamp("created_at"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}
	private static final String SELECT_ALL = "SELECT * FROM employees";

	@Override
	public List<Employee> findAll() {
		List<Employee> result = new ArrayList<>();;
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();
		) {
			
			while (rset.next()) {
				Employee temp = new Employee();
				temp.setId(rset.getInt("id"));
				temp.setEmployeeId(rset.getString("employeeId"));
				temp.setName(rset.getString("name"));
				temp.setBirthday(rset.getDate("birthday"));
				temp.setEmail(rset.getString("email"));
				temp.setPicture(rset.getClob("picture"));
				temp.setCreated_at(rset.getTimestamp("created_at"));
				result.add(temp);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}
	private static final String DELETE = "DELETE FROM employees e WHERE e.id = ?";
	@Override
	public void deleteById(Integer id) {
		try (
			Connection conn = dataSource.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(DELETE);
		) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

}
