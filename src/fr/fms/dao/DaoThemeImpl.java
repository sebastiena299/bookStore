package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import fr.fms.entities.Theme;

public class DaoThemeImpl implements Dao<Theme> {

	/**
	 * @param Object of type Theme
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean create(Theme theme) {
		String query = "INSERT INTO themes (name) VALUES (?)";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, theme.getName());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating theme");
		}
		return false;
	}

	/**
	 * @param Object of type Theme
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean update(Theme theme) {
		String query = "UPDATE themes SET name = ? WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, theme.getName());
			ps.setInt(2, theme.getId());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when updating theme");
		}
		return false;
	}

	/**
	 * @param Identifier of the theme to be deleted
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM themes WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when deleting theme");
		}
		return false;
	}

	/**
	 * @param Identifier of the theme to be read
	 * @return Object of type Theme
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public Theme read(int id) {
		String query = "SELECT * FROM themes WHERE id = ?";
		Theme theme = new Theme();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			theme.setId(rs.getInt("id"));
			theme.setName(rs.getString("name"));
			return theme;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read theme");
		}
		return null;
	}

	/**
	 * @return List object of type Theme
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public List<Theme> readAll() {
		String query = "SELECT * FROM themes";
		List<Theme> themes = new ArrayList<Theme>();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Theme theme = new Theme();
				theme.setId(rs.getInt("id"));
				theme.setName(rs.getString("name"));
				themes.add(theme);
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read theme");
		}
		return themes;
	}
	
	

}
