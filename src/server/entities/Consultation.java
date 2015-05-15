package server.entities;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Paul on 02/05/2015.
 */
public class Consultation implements Serializable{

    private Integer id;
    private User patient;
    private User doctor;
    private String description;
    private Date consultationDate;
    private Integer closed;
    private Integer hasArrived;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public Integer getHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(int hasArrived) {
        this.hasArrived = hasArrived;
    }
}
