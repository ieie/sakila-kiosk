package org.ieie.pets.sakilakiosk.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ievgenii on 3/10/14.
 */

@Entity
public class Country extends BaseEntity {

    @Id
    @Column(name = "country_id")
    private long id;

    @Column(length = 50)
    private String country;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
