package fr.fms.business;

import java.util.List;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Order;

public interface IBusinessOrder {
	
	public Dao<Order> orderDao = DaoFactory.getOrderDao();
	
	public List<Order> getAllOrders();
	public Order getOrderById(int id);
	public boolean createOrder(Order order);
	public boolean updateOrder(Order order);
	public boolean deleteOrder(Order order);

}
