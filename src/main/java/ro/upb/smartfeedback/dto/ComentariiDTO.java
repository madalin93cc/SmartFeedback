package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.config.DatasourceConfig;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;

/**
 * Created by George on 12/8/2015.
 */
public class ComentariiDTO {
    private String nume;
    private String comentariu;
    private String data;

    public ComentariiDTO(String nume, String comentariu, String data) {
        this.nume = nume;
        this.comentariu = comentariu;
        this.data = data;
    }

    public ComentariiDTO(RaspunsIntrebare rasp) {
        this.nume = rasp.getIdUser().getNume() + " " + rasp.getIdUser().getPrenume();
        this.comentariu = rasp.getRaspuns();
        this.data = rasp.getCreatedAt().toString();
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComentariiDTO that = (ComentariiDTO) o;

        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        if (comentariu != null ? !comentariu.equals(that.comentariu) : that.comentariu != null) return false;
        return !(data != null ? !data.equals(that.data) : that.data != null);

    }

    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 31 * result + (comentariu != null ? comentariu.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
