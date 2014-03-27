import org.hibernate.Session;
import org.ieie.pets.sakilakiosk.jpa.HibernateUtilities;
import org.ieie.pets.sakilakiosk.jpa.model.Actor;
import org.ieie.pets.sakilakiosk.jpa.repository.ActorRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

/**
 * Created by ievgenii on 3/1/14.
 */
public class App {

    public static void main(String... args){
        App app = new App();
//        app.runJPA();
        app.runHibernate();

    }

    public void runHibernate(){
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        ActorRepository repository = new ActorRepository();
        repository.setSession(session);
        List<Actor> actors = repository.findAllActors();
        for(Actor actor : actors){
            System.out.println(actor);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void runJPA(){
        EntityManager entityManager = Persistence.createEntityManagerFactory("ActorService").createEntityManager();
        ActorRepository repository = new ActorRepository();
        repository.setEntityManager(entityManager);
        Collection<Actor> actors = repository.findAllActors();
        for(Actor actor : actors){
            System.out.println(actor);
        }
    }
}
