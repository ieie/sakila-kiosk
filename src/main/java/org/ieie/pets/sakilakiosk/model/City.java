package org.ieie.pets.sakilakiosk.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "city")
public class City extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "city_id")
    private long id;

    @Column(length = 50)
    private String city;

    @ManyToOne @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
