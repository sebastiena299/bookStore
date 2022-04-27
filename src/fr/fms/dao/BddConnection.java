package fr.fms.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection {
	
	private static Connection connexion = null;
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;

	/**
	 * Bloc d'initialisation static :
	 * S'execute une seule fois au chargement de la classe avant l'appel des contructeurs 
	 * Ne s'execute pas aux instanciations
	 */
	static
	{
		Properties props = new Properties();
		try (FileInputStream fs = new FileInputStream("files/config.properties")) {
			props.load(fs);
			driver = props.getProperty("jdbc.driver.class");
			url = props.getProperty("jdbc.url");
			user = props.getProperty("jdbc.user");
			pwd = props.getProperty("jdbc.password");
			
			Class.forName(driver);
			connexion = DriverManager.getConnection(url, user, pwd);
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		return connexion;
	}

}
