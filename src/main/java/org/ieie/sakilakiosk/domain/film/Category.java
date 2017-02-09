package org.ieie.sakilakiosk.domain.film;

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
@Table(name = "category")
@Setter
@Getter
@ToString
@Builder
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(length = 25)
    private String name;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category that = (Category) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
