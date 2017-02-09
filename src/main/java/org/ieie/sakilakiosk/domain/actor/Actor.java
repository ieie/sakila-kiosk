package org.ieie.sakilakiosk.domain.actor;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 3/8/14.
 */
@Entity
@Table(name = "actor")
@Getter
@Setter
@ToString
@Builder@NoArgsConstructor@AllArgsConstructor
public class Actor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private long id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;

        Actor that = (Actor) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }

//    @Override
//    public String toString() {
//        return "Actor { " + firstName + " " + lastName + " :: " + getLastUpdate() + '}';
//    }
}
