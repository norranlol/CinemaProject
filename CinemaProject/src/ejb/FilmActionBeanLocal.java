package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Film;

@Local
public interface FilmActionBeanLocal {
	public List<Film> getListOfFilms();
}
