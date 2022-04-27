package fr.fms.business;

import java.util.List;

import fr.fms.dao.DaoFactory;
import fr.fms.dao.DaoOrderImpl;
import fr.fms.entities.Order;

public interface IBusinessOrder {
	
	public DaoOrderImpl orderDao = DaoFactory.getOrderDao();
	
	public List<Order> getAllOrders();
	public Order getOrderById(int id);
	public boolean createOrder(Order order);
	public boolean updateOrder(Order order);
	public boolean deleteOrder(Order order);

}
