package org.ieie.sakilakiosk.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ieie.sakilakiosk.domain.address.Address;

import javax.persistence.*;
import java.util.Date;
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
@Builder
public class Staff  {

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

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;

        Staff that = (Staff) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }
}
