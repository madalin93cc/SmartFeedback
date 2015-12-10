package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.config.DatasourceConfig;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.utils.UserTypeEnum;

import java.util.Date;

/**
 * Created by George on 12/8/2015.
 */
public class ComentariiDTO {
    private String nume;
    private String comentariu;
    private Date data;
    private UserTypeEnum userType;

    public ComentariiDTO(String nume, String comentariu, Date data, UserTypeEnum userType) {
        this.nume = nume;
        this.comentariu = comentariu;
        this.data = data;
        this.userType = userType;
    }

    public ComentariiDTO(RaspunsIntrebare rasp) {
        this.nume = rasp.getIdUser().getNume() + " " + rasp.getIdUser().getPrenume();
        this.comentariu = rasp.getRaspuns();
        this.data = rasp.getCreatedAt();
        this.userType = (rasp.getIdUser().getIdProfesor() != null) ? UserTypeEnum.PROFESOR: (rasp.getIdUser().getIdStudent() != null)? UserTypeEnum.STUDENT: null;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComentariiDTO that = (ComentariiDTO) o;

        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        if (comentariu != null ? !comentariu.equals(that.comentariu) : that.comentariu != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return userType == that.userType;

    }

    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 31 * result + (comentariu != null ? comentariu.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
