package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import fr.fms.entities.Order;

public class DaoOrderImpl implements Dao<Order> {

	/**
	 * @param Object of type Order
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean create(Order order) {
		String query = "INSERT INTO orders (idUser, totalAmount, createdAt) VALUES (?, ?, NOW())";
		try(PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, order.getIdUser());
			ps.setFloat(2, order.getTotalAmount());
			ps.executeUpdate();
			try(ResultSet rs = ps.getGeneratedKeys()) {
				if(rs.next()) {
					order.setId(rs.getInt(1));
					return true;
				}
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating a order");
		}
		return false;
	}

	/**
	 * @param Object of type Order
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean update(Order order) {
		String query = "UPDATE orders SET idUser = ?, totalAmount = ? WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, order.getIdUser());
			ps.setFloat(2, order.getTotalAmount());
			ps.setInt(3, order.getId());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when updating a order");
		}
		return false;
	}

	/**
	 * @param Identifier of the order to be deleted
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM orders WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when delete a order");
		}
		return false;
	}

	/**
	 * @param Identifier of the order to be deleted
	 * @return Object of type Order
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public Order read(int id) {
		String query = "SELECT * FROM orders WHERE id = ?";
		Order order = new Order();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			order.setId(rs.getInt("id"));
			order.setIdUser(rs.getInt("idUser"));
			order.setTotalAmount(rs.getFloat("totalAmount"));
			order.setCreatedAt(rs.getDate("createdAt"));
			return order;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read a order");
		}
		return null;
	}

	/**
	 * @return List object of type Order
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public List<Order> readAll() {
		String query = "SELECT * FROM orders";
		List<Order> orders = new ArrayList<Order>();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setIdUser(rs.getInt("idUser"));
				order.setTotalAmount(rs.getFloat("totalAmount"));
				order.setCreatedAt(rs.getDate("createdAt"));
				orders.add(order);
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read all orders");
		}
		return orders;
	}

}
