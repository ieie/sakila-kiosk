import org.hibernate.Session;
import org.ieie.sakilakiosk.repository.hibernate.FilmRepository;
import org.ieie.sakilakiosk.repository.hibernate.HibernateUtilities;
import org.ieie.sakilakiosk.model.Actor;
import org.ieie.sakilakiosk.repository.hibernate.ActorRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collection;

/**
 * Created by ievgenii on 3/1/14.
 */
public class App {

    public static void main(String... args){
        App app = new App();
//        app.runJPA();
//        app.runHibernate();
        app.runRound();
    }

    public void runRound(){
        float num = 10/3;
        System.out.println(num);
    }

    public void runHibernate(){
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
//        ActorRepository repository = new ActorRepository();
//
//        repository.setSession(session);
//        List<Actor> actors = repository.findAllActors();
//        for(Actor actor : actors){
//            System.out.println(actor);
//        }
        FilmRepository filmRepository = new FilmRepository();
        filmRepository.setSession(session);
        session.getTransaction().commit();
        session.close();

    }

    public void runJPA(){
        EntityManager entityManager = Persistence.createEntityManagerFactory("ActorService").createEntityManager();
        ActorRepository repository = new ActorRepository();

//        repository.setEntityManager(entityManager);
        Collection<Actor> actors = repository.findAllActors();
        for(Actor actor : actors){
            System.out.println(actor);
        }
    }
}
