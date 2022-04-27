package fr.fms.business;

import java.util.List;

import fr.fms.dao.DaoFactory;
import fr.fms.dao.DaoOrderDetailImpl;
import fr.fms.entities.OrderDetail;

public interface IBusinessOrderDetail {
	
	public DaoOrderDetailImpl orderDetailDao = DaoFactory.getOrderDetailDao();
	
	public List<OrderDetail> getAllOrderDetails();
	public OrderDetail getOrderDetailById(int id);
	public boolean createOrderDetail(OrderDetail orderDetail);
	public boolean updateOrderDetail(OrderDetail orderDetail);
	public boolean deleteOrderDetail(int id);

}
