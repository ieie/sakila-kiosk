package org.ieie.sakilakiosk.domain.film;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 3/10/14.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
public class Language  {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "language_id")
    private long id;

    @Column(length = 20)
    private String name;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;

        Language that = (Language) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
