package org.ieie.sakilakiosk.domain.address;

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
@Table(name = "address")
@Getter
@Setter
@ToString
@Builder
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "address_id")
    private long id;

    @Column(length = 50)
    private String address;

    @Column(length = 50)
    private String address2;

    @Column(length = 20)
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(length = 20)
    private String phone;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address that = (Address) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
