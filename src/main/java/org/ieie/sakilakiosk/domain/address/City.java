package org.ieie.sakilakiosk.domain.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "city_id")
    private long id;

    @Column(length = 50)
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "address")
    private List<Address> addresses;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City that = (City) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
