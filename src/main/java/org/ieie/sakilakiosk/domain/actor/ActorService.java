package org.ieie.sakilakiosk.domain.actor;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ievgenii on 06.02.17.
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ActorService {
    @NotNull
    private ActorRepository repository;

    public List<Actor> getAllActors() {
        return repository.findAll();
    }

    public Actor add(Actor entity) {
        return repository.save(entity);
    }
}
