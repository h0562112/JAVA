package employee.model;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;

import employee.constant.SystemService;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String  employeeId; 
    private String  name;
    private Date    birthday;
    private String  email;
    private Clob    picture;
//    private String  dataUri;
    private Timestamp created_at;
    
	public Employee() {
		super();
	}

	public Employee(Integer id, String employeeId, String name, Date birthday, String email, Clob picture,
			Timestamp created_at) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.picture = picture;
		this.created_at = created_at;
	}
	public Employee(Integer id, String employeeId, String name, Date birthday, String email, Clob picture) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Clob getPicture() {
		return picture;
	}

	public void setPicture(Clob picture) {
		this.picture = picture;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDataUri() throws Exception {
		return SystemService.clobToString(picture);
	}

//	public void setDataUri(String dataUri) {
//		this.dataUri = dataUri;
//	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeId=" + employeeId + ", name=" + name + ", birthday=" + birthday
				+ ", email=" + email + ", $created_at=" + created_at + "]";
	}
    
    
}
