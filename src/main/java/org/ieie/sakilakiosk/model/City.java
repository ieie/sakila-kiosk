package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "city")
@Getter
@Setter
@ToString
public class City extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "city_id")
    private long id;

    @Column(length = 50)
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;
}
