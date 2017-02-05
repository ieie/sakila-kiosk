package org.ieie.sakilakiosk.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by ievgenii on 3/8/14.
 */
@Entity
@Table(name = "actor")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class Actor extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private long id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

//    @Override
//    public String toString() {
//        return "Actor { " + firstName + " " + lastName + " :: " + getLastUpdate() + '}';
//    }
}
