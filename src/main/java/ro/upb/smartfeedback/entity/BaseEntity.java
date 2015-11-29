package ro.upb.smartfeedback.entity;

import java.io.Serializable;

/**
 * Created by Madalin.Colezea on 7/2/2015.
 */
public interface BaseEntity extends Serializable{
    public Long getId();

    public void setId(Long id);

    public boolean equals(Object o);

    public int hashCode();
}
