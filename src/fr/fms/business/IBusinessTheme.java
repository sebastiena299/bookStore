package fr.fms.business;

import java.util.List;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Theme;

public interface IBusinessTheme {
	
	public Dao<Theme> themeDao = DaoFactory.getThemeDao();
	
	public List<Theme> getAllThemes();
	public Theme getThemeById(int id);
	public boolean createTheme(Theme theme);
	public boolean updateTheme(Theme theme);
	public boolean deleteTheme(int id);

}
