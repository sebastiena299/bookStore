package fr.fms.dao;

public class DaoFactory {
	
	public static DaoBookImpl getBookDao() {
		return new DaoBookImpl();
	}
	
	public static DaoCustomerImpl getCustomerDao() {
		return new DaoCustomerImpl();
	}
	
	public static DaoOrderImpl getOrderDao() {
		return new DaoOrderImpl();
	}
	
	public static DaoOrderDetailImpl getOrderDetailDao() {
		return new DaoOrderDetailImpl();
	}
	
	public static DaoThemeImpl getThemeDao() {
		return new DaoThemeImpl();
	}

}
