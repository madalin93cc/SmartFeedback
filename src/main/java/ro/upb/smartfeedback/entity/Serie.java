package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by George on 11/23/2015.
 */
@Entity
@Table(name = "serie")
public class Serie implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nume", length = 50, nullable = false)
    private String nume;

    @Column(name = "code", length = 50, nullable = false)
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_sectie", unique = false, nullable = false, updatable = true)
    private Sectie idSectie;

    public Serie() {
    }

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

    public Sectie getIdSectie() {
        return idSectie;
    }

    public void setIdSectie(Sectie idSectie) {
        this.idSectie = idSectie;
    }

    public Serie(String nume, String code, Sectie idSectie) {
        this.nume = nume;
        this.code = code;
        this.idSectie = idSectie;
    }

    public Serie(String code, Sectie idSectie) {
        this.code = code;
        this.idSectie = idSectie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Serie that = (Serie) o;

        if (!id.equals(that.id)) return false;
        if (!nume.equals(that.nume)) return false;
        if (!code.equals(that.code)) return false;
        return idSectie.equals(that.idSectie);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nume.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + idSectie.hashCode();
        return result;
    }
}
