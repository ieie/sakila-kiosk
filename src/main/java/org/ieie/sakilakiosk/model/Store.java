package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 */

@Entity
@Table(name = "store")
@Getter
@Setter
@ToString
public class Store extends BaseEntity {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToOne
    private Staff managerStaff;
    @ManyToOne
    private Address address;

    @OneToMany
    private List<Inventory> inventories;
}
