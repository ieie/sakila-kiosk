package org.ieie.pets.sakilakiosk.model;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity@Table(name = "inventory")
public class Inventory extends BaseEntity {

    @Id @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToOne
    private Film film;

    @ManyToOne
    private Store store;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
