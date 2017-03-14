package org.ieie.sakilakiosk.domain.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ievgenii on 06.02.17.
 */
@Service
public class ActorService {

    private final ActorRepository repository;

    @Autowired
    public ActorService(ActorRepository repository) {
        this.repository = repository;
    }

    public List<Actor> getAllActors() {
        return repository.findAll();
    }

    public Actor add(Actor entity) {
        return repository.save(entity);
    }
}
