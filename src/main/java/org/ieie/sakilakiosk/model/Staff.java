package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 * https://github.com/ieie/sakila-kiosk.git
 */

@Entity
@Table(name = "staff")
@Getter
@Setter
@ToString
public class Staff extends BaseEntity {

    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @ManyToOne
    private Address address;

    @Lob
    private byte[] picture;

    @Column(length = 50)
    private String email;

    @OneToMany
    private List<Store> stores;

    private int active;

    @Column(length = 16)
    private String username;

    @Column(length = 40)
    private String password;
}
