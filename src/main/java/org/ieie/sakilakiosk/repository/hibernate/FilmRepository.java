package org.ieie.sakilakiosk.repository.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ieie.sakilakiosk.model.Actor;
import org.ieie.sakilakiosk.model.Film;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by ievgenii on 01.04.14.
 */
public class FilmRepository {
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public Film findFilm(long id) {
        return (Film) session.get(Film.class, id);
    }

    public List<Film> findAllFilms() {
        Query query = session.createQuery("from Film");
        return (List<Film>) query.list();
    }

    public Actor createFilm() {
        throw new NotImplementedException();
    }

    public void remove(Film film) {
        session.delete(film);
    }

    public void remove(long id) {
        Film film = findFilm(id);
        if (film != null) {
            session.delete(film);
        }
    }

}
