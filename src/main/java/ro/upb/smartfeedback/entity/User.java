package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by colez on 23/11/2015.
 */
@Entity
@Table(name = "UTILIZATOR")
public class User implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "prenume", length = 50, nullable = false)
    private String prenume;

    @Column(name = "nume", length = 50, nullable = false)
    private String nume;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_student"), name = "student_id", unique = true, nullable = false, updatable = true)
    private Student fkStudent;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_profesor"), name = "profesor_id", unique = true, nullable = false, updatable = true)
    private Student fkProfesor;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student getFkStudent() {
        return fkStudent;
    }

    public void setFkStudent(Student fkStudent) {
        this.fkStudent = fkStudent;
    }

    public Student getFkProfesor() {
        return fkProfesor;
    }

    public void setFkProfesor(Student fkProfesor) {
        this.fkProfesor = fkProfesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (prenume != null ? !prenume.equals(user.prenume) : user.prenume != null) return false;
        if (nume != null ? !nume.equals(user.nume) : user.nume != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (fkStudent != null ? !fkStudent.equals(user.fkStudent) : user.fkStudent != null) return false;
        return !(fkProfesor != null ? !fkProfesor.equals(user.fkProfesor) : user.fkProfesor != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fkStudent != null ? fkStudent.hashCode() : 0);
        result = 31 * result + (fkProfesor != null ? fkProfesor.hashCode() : 0);
        return result;
    }
}