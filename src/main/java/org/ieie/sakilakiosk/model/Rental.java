package org.ieie.sakilakiosk.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "rental")
@Getter
@Setter
@ToString
@Builder
public class Rental  {
    @Id
    @Column(name = "rental_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "rental_date")
    private Date rentalDate;

    @OneToOne
    private Inventory inventory;

    @OneToOne
    private Customer customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    private Staff staff;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental)) return false;

        Rental that = (Rental) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
