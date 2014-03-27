package org.ieie.pets.sakilakiosk.jpa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity@Table(name = "rental")
public class Rental extends BaseEntity {
    @Id @Column(name = "rental_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Temporal(TemporalType.DATE)@Column(name = "rental_date")
    private Date rentalDate;

    @OneToOne
    private Inventory inventory;

    @OneToOne
    private Customer customer;

    @Temporal(TemporalType.DATE)@Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    private Staff staff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
