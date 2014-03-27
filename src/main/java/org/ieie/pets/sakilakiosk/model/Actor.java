package org.ieie.pets.sakilakiosk.model;

import javax.persistence.*;

/**
 * Created by ievgenii on 3/8/14.
 */
@Entity
@Table(name = "actor")
public class Actor extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "actor_id")
    private long id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Actor { " + firstName + " " + lastName + " :: " + getLastUpdate() + '}';
    }
}
