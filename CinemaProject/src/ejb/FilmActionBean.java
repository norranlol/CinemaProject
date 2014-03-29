package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Film;

@Stateless
public class FilmActionBean implements FilmActionBeanLocal {

	@PersistenceContext(name = "persistence/cinema", unitName= "CinemaProjectCinema")
	private EntityManager emC;
	
	@PersistenceContext(name = "persistence/bonuses", unitName= "CinemaProjectBonuses")
	private EntityManager emB;
	
    public FilmActionBean() {
    	
    }
    
    @Override
    public List<Film> getListOfFilms(){
    	CriteriaQuery<Film> criteriaQuery = emC.getCriteriaBuilder().createQuery(Film.class);
    	criteriaQuery.select(criteriaQuery.from(Film.class));
    	List<Film> listOfFilms = emC.createQuery(criteriaQuery).getResultList();
    	return listOfFilms;
    }
}

