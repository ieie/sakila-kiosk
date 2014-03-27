package org.ieie.pets.sakilakiosk.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 */

@Entity@Table(name = "store")
public class Store extends BaseEntity {

    @Id@Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToOne
    private Staff managerStaff;
    @ManyToOne
    private Address address;

    @OneToMany
    private List<Inventory> inventories;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }
}
