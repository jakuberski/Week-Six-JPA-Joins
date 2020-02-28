package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "list_details")

public class ListDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIST_ID")
	private int id;
	@Column(name = "LIST_NAME")
	private String listName;
	@Column(name = "TRIP_DATE")
	private LocalDate tripDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "ITEMS_ON_LIST", joinColumns = {
			@JoinColumn(name = "LIST_ID", referencedColumnName = "LIST_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", unique = true) })

	private List<ListItems> listOfItems;

	public ListDetails() {
		// TODO Auto-generated constructor stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<ListItems> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ListItems> listOfItems) {
		this.listOfItems = listOfItems;
	}

	

	public ListDetails(int id, String listName, LocalDate tripDate, Employee employee, List<ListItems> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.employee = employee;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate tripDate, Employee employee, List<ListItems> listOfItems) {
		super();

		this.listName = listName;
		this.tripDate = tripDate;
		this.employee = employee;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate tripDate, Employee employee) {
		super();

		this.listName = listName;
		this.tripDate = tripDate;
		this.employee = employee;

	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", employee=" + employee
				+ ", listOfItems=" + listOfItems + "]";
	}

}
