package org.ieie.pets.sakilakiosk.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ievgenii on 27.03.14.
 */

public class Review {

    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
