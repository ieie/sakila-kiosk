package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "category")
@Setter
@Getter
@ToString
public class Category extends BaseEntity {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(length = 25)
    private String name;
}
