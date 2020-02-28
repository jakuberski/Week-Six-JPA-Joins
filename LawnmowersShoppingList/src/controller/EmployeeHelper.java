package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Employee;

public class EmployeeHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Lawnmowers");

	public void insertEmployee(Employee s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<Employee> showAllEmployee() {
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allEmployee = em.createQuery("SELECT s FROM Employee s").getResultList();
		return allEmployee;
	}
}
