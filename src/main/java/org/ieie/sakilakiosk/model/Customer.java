package org.ieie.sakilakiosk.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    //TODO Implement
}
