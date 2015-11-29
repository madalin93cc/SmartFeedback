package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by George on 11/23/2015.
 */
@Entity
@Table(name = "sectie")
public class Sectie implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nume", length = 50, nullable = false)
    private String nume;

    @Column(name = "code", length = 50, nullable = false)
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sectie sectie = (Sectie) o;

        if (!id.equals(sectie.id)) return false;
        if (!nume.equals(sectie.nume)) return false;
        return code.equals(sectie.code);

    }

    public Sectie(String nume, String code) {
        this.nume = nume;
        this.code = code;
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + nume.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
