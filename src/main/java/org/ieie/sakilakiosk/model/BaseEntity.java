package org.ieie.sakilakiosk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii on 3/10/14.
 */
//@Entity
public abstract class BaseEntity {

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter@Setter
    private Date lastUpdate;

    public abstract long getId();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        if (!lastUpdate.equals(that.lastUpdate) || getId() != that.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int)(getId() * 123 + lastUpdate.hashCode() * 123);
    }

}
