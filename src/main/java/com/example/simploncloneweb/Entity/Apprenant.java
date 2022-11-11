package com.example.simploncloneweb.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "apprenant", schema = "public", catalog = "simplonCloneWeb")
public class Apprenant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "idpromo")
    private Integer idpromo;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "idpromo", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Promotion promotionByIdpromo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apprenant apprenant = (Apprenant) o;

        if (id != null ? !id.equals(apprenant.id) : apprenant.id != null) return false;
        if (username != null ? !username.equals(apprenant.username) : apprenant.username != null) return false;
        if (password != null ? !password.equals(apprenant.password) : apprenant.password != null) return false;
        if (email != null ? !email.equals(apprenant.email) : apprenant.email != null) return false;
        if (nom != null ? !nom.equals(apprenant.nom) : apprenant.nom != null) return false;
        if (prenom != null ? !prenom.equals(apprenant.prenom) : apprenant.prenom != null) return false;
        if (idpromo != null ? !idpromo.equals(apprenant.idpromo) : apprenant.idpromo != null) return false;
        if (createdAt != null ? !createdAt.equals(apprenant.createdAt) : apprenant.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(apprenant.updatedAt) : apprenant.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (idpromo != null ? idpromo.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Promotion getPromotionByIdpromo() {
        return promotionByIdpromo;
    }

    public void setPromotionByIdpromo(Promotion promotionByIdpromo) {
        this.promotionByIdpromo = promotionByIdpromo;
    }
}
