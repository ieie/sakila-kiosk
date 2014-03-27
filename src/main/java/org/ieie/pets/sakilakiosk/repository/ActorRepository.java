package org.ieie.pets.sakilakiosk.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ieie.pets.sakilakiosk.model.Actor;
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


    @PersistenceContext(unitName = "ActorService")
    private EntityManager entityManager;

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Actor findActor(long id) {
        return entityManager.find(Actor.class, id);
    }

    public List<Actor> findAllActors() {
        if(session != null) {
            Query query = session.createQuery("from Actor");
//            List<Actor> actorList = query.list();
            return (List<Actor>) query.list();
        }
        TypedQuery<Actor> query = entityManager.createQuery("SELECT a FROM Actor a", Actor.class);
        return query.getResultList();
    }

    public Actor createActor() {
        throw new NotImplementedException();
//        return null;
    }

    public void remove(Actor actor) {
        entityManager.remove(actor);
    }

    public void remove(long id) {
        Actor actor = findActor(id);
        if(actor != null) {
            entityManager.remove(actor);
        }
    }
}
