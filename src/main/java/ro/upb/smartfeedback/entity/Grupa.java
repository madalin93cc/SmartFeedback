package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by colez on 29/11/2015.
 */
@Entity
@Table(name = "grupa")
public class Grupa implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nume", length = 50, nullable = false)
    private String nume;

    @Column(name = "an", nullable = true)
    private Integer an;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grupa grupa = (Grupa) o;

        if (id != null ? !id.equals(grupa.id) : grupa.id != null) return false;
        if (nume != null ? !nume.equals(grupa.nume) : grupa.nume != null) return false;
        return !(an != null ? !an.equals(grupa.an) : grupa.an != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (an != null ? an.hashCode() : 0);
        return result;
    }
}
