package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.utils.UserTypeEnum;

/**
 * Created by colez on 30/11/2015.
 */
public class UserDTO {

    private Long id;
    private String nume;
    private String prenume;
    private String username;
    private UserTypeEnum userType;
    private String grupa;
    private String seria;

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

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

    public UserDTO(Long id, String nume, String prenume, String username, UserTypeEnum userType, String grupa, String seria) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
        this.userType = userType;
        this.grupa = grupa;
        this.seria = seria;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.nume = user.getNume();
        this.prenume = user.getPrenume();
        this.username = user.getUsername();
        if (user.getIdProfesor() != null){
            this.setUserType(UserTypeEnum.PROFESOR);
        } else if (user.getIdStudent() != null) {
            this.setUserType(UserTypeEnum.STUDENT);
        }
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public UserDTO() {
    }

    public UserDTO(Long id, String nume, String prenume, String username, UserTypeEnum userType) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (id != null ? !id.equals(userDTO.id) : userDTO.id != null) return false;
        if (nume != null ? !nume.equals(userDTO.nume) : userDTO.nume != null) return false;
        if (prenume != null ? !prenume.equals(userDTO.prenume) : userDTO.prenume != null) return false;
        if (username != null ? !username.equals(userDTO.username) : userDTO.username != null) return false;
        return userType == userDTO.userType;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
