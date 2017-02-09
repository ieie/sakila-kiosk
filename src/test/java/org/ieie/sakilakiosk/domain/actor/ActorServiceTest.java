package org.ieie.sakilakiosk.domain.actor;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import lombok.extern.log4j.Log4j2;
import org.ieie.sakilakiosk.config.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ievgenii on 16.05.15.
 */
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
public class ActorServiceTest {

    @Autowired
    private ActorService actorService;


    @Test
    @ExpectedDatabase(assertionMode = NON_STRICT, table = "classpath:org/ieie/sakilakiosk/domain/actor/actors.xml")
    public void actorCouldBeCreated() {
        //given
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Doe");

        Actor actor1 = Actor.builder().firstName("Jane").lastName("Doe").build();
        //when
        actor = actorService.add(actor1);
        //then
        assertNotNull(actor.getId());
        log.debug(actor.toString());

    }
}
