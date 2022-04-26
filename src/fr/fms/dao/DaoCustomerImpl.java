package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import fr.fms.entities.Customer;

public class DaoCustomerImpl implements Dao<Customer> {

	/**
	 * @param Object of type Customer
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean create(Customer customer) {
		String query = "INSERT INTO customers (name, lastname, email, password, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getLastname());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getPhone());
			ps.setString(6, customer.getAddress());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating a customer");
		}
		return false;
	}

	/**
	 * @param Object of type Customer
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean update(Customer customer) {
		String query = "UPDATE customers SET name = ?, lastname = ?, email = ?, password = ?, phone = ?, address = ? WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getLastname());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getPhone());
			ps.setString(6, customer.getAddress());
			ps.setInt(7, customer.getId());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when updating a customer");
		}
		return false;
	}

	/**
	 * @param Identifier of the customer to be deleted
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM customers WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when delete a customer");
		}
		return false;
	}

	/**
	 * @param Identifier of the customer to be displayed
	 * @return Object of type Customer
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public Customer read(int id) {
		String query = "SELECT * FROM customers WHERE id = ?";
		Customer customer = new Customer();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setLastname(rs.getString("lastname"));
			customer.setEmail(rs.getString("email"));
			customer.setPassword(rs.getString("password"));
			customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
			customer.setRoles(rs.getInt("roles"));
			return customer;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read customer by id");
		}
		return null;
	}

	/**
	 * @return List object of type Customer
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public List<Customer> readAll() {
		String query = "SELECT * FROM customers";
		List<Customer> customers = new ArrayList<Customer>();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setLastname(rs.getString("lastname"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customers.add(customer);
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read all customers");
		}
		return customers;
	}



}
