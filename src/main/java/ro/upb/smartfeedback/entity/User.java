package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by colez on 23/11/2015.
 */
@Entity
@Table(name = "utilizator")
public class User implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nume", length = 50, nullable = false)
    private String nume;

    @Column(name = "prenume", length = 50, nullable = false)
    private String prenume;

    public User(String nume, String prenume, String username, String password, String email, Integer tip, Student idStudent, Profesor idProfesor) {
        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tip = tip;
        this.idStudent = idStudent;
        this.idProfesor = idProfesor;
    }

    public User() {

    }

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "tip", nullable = false, length = 11)
    private Integer tip;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_utilizator_student"), name = "id_student", unique = true, nullable = false, updatable = true)
    private Student idStudent;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_utilizator_profesor"), name = "id_profesor", unique = true, nullable = false, updatable = true)
    private Profesor idProfesor;

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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
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

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (nume != null ? !nume.equals(user.nume) : user.nume != null) return false;
        if (prenume != null ? !prenume.equals(user.prenume) : user.prenume != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (tip != null ? !tip.equals(user.tip) : user.tip != null) return false;
        if (idStudent != null ? !idStudent.equals(user.idStudent) : user.idStudent != null) return false;
        return !(idProfesor != null ? !idProfesor.equals(user.idProfesor) : user.idProfesor != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tip != null ? tip.hashCode() : 0);
        result = 31 * result + (idStudent != null ? idStudent.hashCode() : 0);
        result = 31 * result + (idProfesor != null ? idProfesor.hashCode() : 0);
        return result;
    }
}
