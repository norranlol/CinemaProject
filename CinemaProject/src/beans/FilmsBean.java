package beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Film;
import ejb.FilmActionBeanLocal;

@Named("filmsBean")
@SessionScoped
public class FilmsBean implements Serializable {
	
	@EJB
	FilmActionBeanLocal filmAction;
	
	private List<Film> filmsList;

	public List<Film> getFilmsList() {
		filmsList = filmAction.getListOfFilms();
		return filmsList;
	}
}
