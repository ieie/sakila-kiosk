package org.ieie.sakilakiosk.repository.jpa;

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

    @PersistenceContext(unitName = "ActorService")
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Actor findActor(long id) {
        return entityManager.find(Actor.class, id);
    }

    public List<Actor> findAllActors() {
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
