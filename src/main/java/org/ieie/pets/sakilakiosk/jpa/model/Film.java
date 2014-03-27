package org.ieie.pets.sakilakiosk.jpa.model;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity@Table(name = "film")
public class Film {

    @Id @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    //TODO Implement
}
