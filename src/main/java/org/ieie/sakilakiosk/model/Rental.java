package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "rental")
@Getter
@Setter
@ToString
public class Rental extends BaseEntity {
    @Id
    @Column(name = "rental_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "rental_date")
    private Date rentalDate;

    @OneToOne
    private Inventory inventory;

    @OneToOne
    private Customer customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    private Staff staff;
}
