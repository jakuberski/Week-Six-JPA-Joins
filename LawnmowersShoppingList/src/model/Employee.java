package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private int id;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String employeeName) {
		super();
		this.id = id;
		this.employeeName = employeeName;
	}

	public Employee(String employeeName) {
		super();
		this.employeeName = employeeName;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + "]";
	}
}
