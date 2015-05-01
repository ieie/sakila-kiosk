package org.ieie.sakilakiosk.repository.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ieie.sakilakiosk.model.Actor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ievgenii on 3/10/14.
 */
@Stateless
public class ActorRepository {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public Actor findActor(long id) {
        return (Actor) session.get(Actor.class, id);
    }

    public List<Actor> findAllActors() {
        Query query = session.createQuery("from Actor");
        return (List<Actor>) query.list();
    }

    public Actor createActor() {
        throw new NotImplementedException();
    }

    public void remove(Actor actor) {
        session.delete(actor);
    }

    public void remove(long id) {
        Actor actor = findActor(id);
        if (actor != null) {
            session.delete(actor);
        }
    }
}
