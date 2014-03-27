package org.ieie.pets.sakilakiosk.jpa.model;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity@Table(name = "customer")
public class Customer extends BaseEntity {

    @Id @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //TODO Implement
}
