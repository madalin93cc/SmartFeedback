package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by colez on 29/11/2015.
 */
@Entity
@Table(name = "tip_activitate")
public class TipActivitate implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nume")
    private String nume;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipActivitate that = (TipActivitate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(nume != null ? !nume.equals(that.nume) : that.nume != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        return result;
    }
}
