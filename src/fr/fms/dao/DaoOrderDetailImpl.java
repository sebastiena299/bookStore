package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import fr.fms.entities.OrderDetail;

public class DaoOrderDetailImpl implements Dao<OrderDetail> {

	/**
	 * @param Object of type OrderDetail
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean create(OrderDetail orderDetail) {
		String query = "INSERT INTO order_detail (idOrder, idBook, price, quantity) VALUES (?, ?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, orderDetail.getIdOrder());
			ps.setInt(2, orderDetail.getIdBook());
			ps.setFloat(3, orderDetail.getPrice());
			ps.setInt(4, orderDetail.getQuantity());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating order detail");
		}
		return false;
	}

	/**
	 * @param Object of type OrderDetail
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean update(OrderDetail orderDetail) {
		String query = "UPDATE order_detail SET idOrder = ?, idBook = ?, price = ?, quantity = ? WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, orderDetail.getIdOrder());
			ps.setInt(2, orderDetail.getIdBook());
			ps.setFloat(3, orderDetail.getPrice());
			ps.setInt(4, orderDetail.getQuantity());
			ps.setInt(5, orderDetail.getId());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating order detail");
		}
		return false;
	}

	/**
	 * @param Identifier of the order detail to be deleted
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM order_detail WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating order detail");
		}
		return false;
	}

	/**
	 * @param Identifier of the order detail to be deleted
	 * @return Object of type OrderDetail
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public OrderDetail read(int id) {
		String query = "SELECT * FROM order_detail WHERE id = ?";
		OrderDetail orderDetail = new OrderDetail();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			orderDetail.setId(rs.getInt("id"));
			orderDetail.setIdOrder(rs.getInt("idOrder"));
			orderDetail.setIdBook(rs.getInt("idBook"));
			orderDetail.setPrice(rs.getFloat("price"));
			orderDetail.setQuantity(rs.getInt("quantity"));
			return orderDetail;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating order detail");
		}
		return null;
	}

	/**
	 * @return List object of type OrderDetail
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public List<OrderDetail> readAll() {
		String query = "SELECT * FROM order_detail";
		List<OrderDetail> ordersDetails = new ArrayList<OrderDetail>();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setIdOrder(rs.getInt("idOrder"));
				orderDetail.setIdBook(rs.getInt("idBook"));
				orderDetail.setPrice(rs.getFloat("price"));
				orderDetail.setQuantity(rs.getInt("quantity"));
				ordersDetails.add(orderDetail);
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating order detail");
		}
		return ordersDetails;
	}

}
