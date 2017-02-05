package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
public class Address extends BaseEntity{

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

}
