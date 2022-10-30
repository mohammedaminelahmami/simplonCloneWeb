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

    public Integer getIdformateur() {
        return idformateur;
    }

    public void setIdformateur(Integer idformateur) {
        this.idformateur = idformateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != null ? !id.equals(promotion.id) : promotion.id != null) return false;
        if (name != null ? !name.equals(promotion.name) : promotion.name != null) return false;
        if (status != null ? !status.equals(promotion.status) : promotion.status != null) return false;
        if (idformateur != null ? !idformateur.equals(promotion.idformateur) : promotion.idformateur != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (idformateur != null ? idformateur.hashCode() : 0);
        return result;
    }
}
