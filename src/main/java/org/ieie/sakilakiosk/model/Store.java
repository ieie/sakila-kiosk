package org.ieie.sakilakiosk.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ieie.sakilakiosk.domain.address.Address;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 */

@Entity
@Table(name = "store")
@Getter
@Setter
@ToString
@Builder
public class Store {

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

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store that = (Store) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
