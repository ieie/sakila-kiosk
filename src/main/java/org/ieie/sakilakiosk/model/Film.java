package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ievgenii on 23.03.14.
 */
@Entity
@Table(name = "film")
@Embeddable
@Getter
@Setter
@ToString
public class Film extends BaseEntity implements Serializable {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String title;

    private String description;

    @Column(name = "release_year")
    @Temporal(TemporalType.DATE)
    private Date releaseYear;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @OneToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @Column(name = "rental_duration")
    private int rentalDuration;

    @Column(name = "rental_rate", scale = 2, precision = 4)
    private double rentalRate;

    private int length;

    @Column(name = "replacement_cost", precision = 5, scale = 2)
    private double replacementCost;

    @Column(length = 5)
    private String rating;

    @Column(name = "special_features", length = 54)
    private String specialFeatures;

    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

//    @OneToMany@JoinTable(name = "film_text",
//            joinColumns = @JoinColumn(name = "film_id"))
//    private List<Review> reviews;
}
