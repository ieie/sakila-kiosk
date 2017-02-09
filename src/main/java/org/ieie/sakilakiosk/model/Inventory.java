package org.ieie.sakilakiosk.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ieie.sakilakiosk.domain.film.Film;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "inventory")
@Getter
@Setter
@ToString
@Builder
public class Inventory  {

    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToOne
    private Film film;

    @ManyToOne
    private Store store;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory)) return false;

        Inventory that = (Inventory) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
