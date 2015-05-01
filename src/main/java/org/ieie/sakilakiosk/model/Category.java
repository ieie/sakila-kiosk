package org.ieie.sakilakiosk.model;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity @Table(name = "category")
public class Category extends BaseEntity {

    @Id @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(length = 25)
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
