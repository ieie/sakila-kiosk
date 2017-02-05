package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ievgenii on 3/10/14.
 */

@Entity
@Getter
@Setter
@ToString
public class Country extends BaseEntity {

    @Id
    @Column(name = "country_id")
    private long id;

    @Column(length = 50)
    private String country;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
}
