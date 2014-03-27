package org.ieie.pets.sakilakiosk.model;

import javax.persistence.*;

/**
 * Created by ievgenii on 3/10/14.
 */
@Entity
public class Language extends BaseEntity {

    @Id@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "language_id")
    private long id;

    @Column(length = 20)
    private String name;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
