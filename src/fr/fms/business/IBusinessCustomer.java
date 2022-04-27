package fr.fms.business;

import java.util.List;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Customer;

public interface IBusinessCustomer {
	
	public Dao<Customer> customerDao = DaoFactory.getCustomerDao();
	
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public boolean createCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(int id);

}
