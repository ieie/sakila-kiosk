package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by ievgenii on 3/10/14.
 */
@Entity
@Getter
@Setter
@ToString
public class Language extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "language_id")
    private long id;

    @Column(length = 20)
    private String name;
}
