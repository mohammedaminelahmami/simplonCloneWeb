package com.example.simploncloneweb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "promotion", schema = "public", catalog = "simplonCloneWeb")
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @Basic
    @Column(name = "annee")
    private int annee;
    @Basic
    @Column(name = "idformateur")
    private Integer idformateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Integer getIdformateur() {
        return idformateur;
    }

    public void setIdformateur(Integer idformateur) {
        this.idformateur = idformateur;
    }
}
