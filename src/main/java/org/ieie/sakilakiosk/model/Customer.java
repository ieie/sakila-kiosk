package org.ieie.sakilakiosk.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@Builder
public class Customer  {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer that = (Customer) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }

    //TODO Implement
}
