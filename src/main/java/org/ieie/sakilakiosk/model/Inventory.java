package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "inventory")
@Getter
@Setter
@ToString
public class Inventory extends BaseEntity {

    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToOne
    private Film film;

    @ManyToOne
    private Store store;
}
