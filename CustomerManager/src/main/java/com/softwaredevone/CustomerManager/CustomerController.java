package com.softwaredevone.CustomerManager;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CustomerController {
	
	private EntityManagerFactory EMF;
	
	public CustomerController() {
		this.EMF = Persistence.createEntityManagerFactory("CustomerManager");
	}
	
	public void allCustomers() {
		EntityManager em = this.EMF.createEntityManager();
		String query = "SELECT c FROM Customer c";
		
		TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
		
		List<Customer> allCustomers;
		
		try {
			allCustomers = tq.getResultList();
			for(Customer c: allCustomers) {
				System.out.println("Customer #" + c.getId() + ": " + c.getFirstName() + " " + c.getLastName());
			}
		}
		catch(NoResultException nre) {
			nre.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	public void getCustomer(int id) {
		EntityManager em = this.EMF.createEntityManager();
		String query = "SELECT c FROM Customer c WHERE c.id = :id";
		
		TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
		tq.setParameter("id", id);
		
		Customer cust = null;
		
		try {
			cust = tq.getSingleResult();
			System.out.println("Customer #" + cust.getId() + ": " + cust.getFirstName() + " " + cust.getLastName());
			
		}
		catch(NoResultException nre) {
			nre.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	public void addCustomer(int id, String firstName, String lastName, int age) {
		
		EntityManager em = this.EMF.createEntityManager();
		EntityTransaction et = null;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			
			Customer cust = new Customer();
			cust.setId(id);
			cust.setFirstName(firstName);
			cust.setLastName(lastName);
			cust.setAge(age);
			
			em.persist(cust);
			et.commit();
			
			System.out.println("Customer #" + firstName + " has been saved!");
			
		} 
		catch(Exception e) {
			
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
			
		} finally {
			em.close();
		}

	}
	public void editCustomer(String firstName, String lastName, int age, int id) {
		
		EntityManager em = this.EMF.createEntityManager();
		EntityTransaction et = null;
		
		Customer cust = null;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			
			cust = em.find(Customer.class, id);
			
			if(cust == null) {
				System.out.println("Customer not found!");
				return;
			}
			
			cust.setFirstName(firstName);
			cust.setLastName(lastName);
			cust.setAge(age);
			
			em.persist(cust);
			et.commit();
			
			System.out.println("Customer #" + id + " has been updated!");
				
		}
		catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	public void deleteCustomer(int id) {
		
		EntityManager em = this.EMF.createEntityManager();
		EntityTransaction et = null;
		
		Customer cust = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			
			cust = em.find(Customer.class, id);
			if(cust == null) {
				System.out.println("Customer not found!");
				return;
			}
			
			em.remove(cust);
			
			em.flush();
			et.commit();
			
			System.out.println("Customer #" + id + " has been deleted!");
		}
		catch(Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}


}
