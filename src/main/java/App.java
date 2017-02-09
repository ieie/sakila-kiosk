//import org.hibernate.Session;
//import org.ieie.sakilakiosk.repository.hibernate.HibernateFilmRepository;
//import org.ieie.sakilakiosk.repository.hibernate.HibernateUtilities;

import org.ieie.sakilakiosk.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ievgenii on 3/1/14.
 */
public class App {

    public static void main(String... args){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        System.out.println(ctx.getBeanDefinitionNames());
    }


}
