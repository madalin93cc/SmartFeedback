package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.utils.TipIntrebareEnum;
import ro.upb.smartfeedback.utils.TipRaspunsEnum;

import java.util.List;

/**
 * Created by colez on 06/12/2015.
 */
public class CompletareFeedbackDTO {
    private Long idFeedback;
    private Integer notaGenerala;
    private Integer interactiune;
    private Integer gradIntelegere;
    private Integer organizare;
    private Integer expunere;
    private String comentariu;

    public CompletareFeedbackDTO() {
    }

    public CompletareFeedbackDTO(Integer notaGenerala, Integer interactiune, Integer gradIntelegere, Long idFeedback, Integer organizare, Integer expunere, String comentariu) {
        this.idFeedback = idFeedback;
        this.notaGenerala = notaGenerala;
        this.interactiune = interactiune;
        this.gradIntelegere = gradIntelegere;
        this.organizare = organizare;
        this.expunere = expunere;
        this.comentariu = comentariu;
    }

    public CompletareFeedbackDTO(List<RaspunsIntrebare> raspunsIntrebareList){
        this.idFeedback = raspunsIntrebareList.get(0).getIdFeedback().getId();
        for (RaspunsIntrebare r: raspunsIntrebareList){
            if (r.getTipRaspuns().equals(TipRaspunsEnum.INTREBARE.getId())){
                if (r.getIdIntrebare().equals(TipIntrebareEnum.NOTA_GENERALA)){
                    this.notaGenerala = Integer.parseInt(r.getRaspuns());
                }
                if (r.getIdIntrebare().equals(TipIntrebareEnum.INTERACTIUNE)){
                    this.interactiune = Integer.parseInt(r.getRaspuns());
                }
                if (r.getIdIntrebare().equals(TipIntrebareEnum.EXPUNERE)){
                    this.expunere = Integer.parseInt(r.getRaspuns());
                }
                if (r.getIdIntrebare().equals(TipIntrebareEnum.GRAD_INTELEGERE)){
                    this.gradIntelegere = Integer.parseInt(r.getRaspuns());
                }
                if (r.getIdIntrebare().equals(TipIntrebareEnum.ORGANIZARE)){
                    this.organizare = Integer.parseInt(r.getRaspuns());
                }
            }
        }
    }

    public Long getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Long idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Integer getNotaGenerala() {
        return notaGenerala;
    }

    public void setNotaGenerala(Integer notaGenerala) {
        this.notaGenerala = notaGenerala;
    }

    public Integer getInteractiune() {
        return interactiune;
    }

    public void setInteractiune(Integer interactiune) {
        this.interactiune = interactiune;
    }

    public Integer getGradIntelegere() {
        return gradIntelegere;
    }

    public void setGradIntelegere(Integer gradIntelegere) {
        this.gradIntelegere = gradIntelegere;
    }

    public Integer getOrganizare() {
        return organizare;
    }

    public void setOrganizare(Integer organizare) {
        this.organizare = organizare;
    }

    public Integer getExpunere() {
        return expunere;
    }

    public void setExpunere(Integer expunere) {
        this.expunere = expunere;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompletareFeedbackDTO that = (CompletareFeedbackDTO) o;

        if (idFeedback != null ? !idFeedback.equals(that.idFeedback) : that.idFeedback != null) return false;
        if (notaGenerala != null ? !notaGenerala.equals(that.notaGenerala) : that.notaGenerala != null) return false;
        if (interactiune != null ? !interactiune.equals(that.interactiune) : that.interactiune != null) return false;
        if (gradIntelegere != null ? !gradIntelegere.equals(that.gradIntelegere) : that.gradIntelegere != null)
            return false;
        if (organizare != null ? !organizare.equals(that.organizare) : that.organizare != null) return false;
        if (expunere != null ? !expunere.equals(that.expunere) : that.expunere != null) return false;
        return !(comentariu != null ? !comentariu.equals(that.comentariu) : that.comentariu != null);

    }

    @Override
    public int hashCode() {
        int result = idFeedback != null ? idFeedback.hashCode() : 0;
        result = 31 * result + (notaGenerala != null ? notaGenerala.hashCode() : 0);
        result = 31 * result + (interactiune != null ? interactiune.hashCode() : 0);
        result = 31 * result + (gradIntelegere != null ? gradIntelegere.hashCode() : 0);
        result = 31 * result + (organizare != null ? organizare.hashCode() : 0);
        result = 31 * result + (expunere != null ? expunere.hashCode() : 0);
        result = 31 * result + (comentariu != null ? comentariu.hashCode() : 0);
        return result;
    }
}
