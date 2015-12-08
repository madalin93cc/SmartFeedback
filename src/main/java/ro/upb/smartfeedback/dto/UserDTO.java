package ro.upb.smartfeedback.dto;

/**
 * Created by colez on 30/11/2015.
 */
public class UserDTO {

    private Long id;
    private String nume;
    private String prenume;
    private String username;

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

    public UserDTO() {
    }

    public UserDTO(Long id, String nume, String prenume, String username) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (id != null ? !id.equals(userDTO.id) : userDTO.id != null) return false;
        if (nume != null ? !nume.equals(userDTO.nume) : userDTO.nume != null) return false;
        if (prenume != null ? !prenume.equals(userDTO.prenume) : userDTO.prenume != null) return false;
        return !(username != null ? !username.equals(userDTO.username) : userDTO.username != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
