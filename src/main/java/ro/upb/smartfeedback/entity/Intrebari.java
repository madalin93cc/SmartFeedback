package ro.upb.smartfeedback.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@Entity
@Table(name = "intrebari")
public class Intrebari {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "intrebare")
    private String intrebare;

    @ManyToMany(mappedBy = "intrebari")
    private List<Feedback> feedbacks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntrebare() {
        return intrebare;
    }

    public void setIntrebare(String intrebare) {
        this.intrebare = intrebare;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Intrebari intrebari = (Intrebari) o;

        if (id != null ? !id.equals(intrebari.id) : intrebari.id != null) return false;
        if (intrebare != null ? !intrebare.equals(intrebari.intrebare) : intrebari.intrebare != null) return false;
        return !(feedbacks != null ? !feedbacks.equals(intrebari.feedbacks) : intrebari.feedbacks != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (intrebare != null ? intrebare.hashCode() : 0);
        result = 31 * result + (feedbacks != null ? feedbacks.hashCode() : 0);
        return result;
    }
}
