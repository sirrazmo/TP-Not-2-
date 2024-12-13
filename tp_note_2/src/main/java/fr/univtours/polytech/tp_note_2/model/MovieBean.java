package fr.univtours.polytech.tp_note_2.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "MOVIE")
public class MovieBean implements Serializable {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "NOTE")
    private Integer note;

    @Column(name = "URL1")
    private String url1;

    @Column(name = "URL2")
    private String url2;

    @Transient
    private String actors;

    @Transient
    private String year;

    @Transient
    private String imgPoster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    @XmlTransient
    @JsonIgnore
    public String getActors() {
        return actors;
    }

    @XmlTransient
    @JsonIgnore
    public void setActors(String actors) {
        this.actors = actors;
    }

    @XmlTransient
    @JsonIgnore
    public String getYear() {
        return year;
    }

    @XmlTransient
    @JsonIgnore
    public void setYear(String year) {
        this.year = year;
    }

    @XmlTransient
    @JsonIgnore
    public String getImgPoster() {
        return imgPoster;
    }

    @XmlTransient
    @JsonIgnore
    public void setImgPoster(String imgPoster) {
        this.imgPoster = imgPoster;
    }

}
