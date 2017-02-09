package org.ieie.sakilakiosk.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ievgenii on 3/10/14.
 */

@Entity
@Getter
@Setter
@ToString
@Builder
public class Country  {

    @Id
    @Column(name = "country_id")
    private long id;

    @Column(length = 50)
    private String country;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country that = (Country) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
