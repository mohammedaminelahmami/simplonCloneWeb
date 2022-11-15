package com.example.simploncloneweb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brief", schema = "public", catalog = "simplonCloneWeb")
public class Brief {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "context")
    private String context;
    @Basic
    @Column(name = "deadline")
    private Integer deadline;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @Basic
    @Column(name = "promoid")
    private Integer promoid;
    @ManyToOne
    @JoinColumn(name = "promoid", referencedColumnName = "id",insertable = false, updatable = false)
    private Promotion promotionByPromoid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public Integer getPromoid() {
        return promoid;
    }

    public void setPromoid(Integer promoid) {
        this.promoid = promoid;
    }

    public Promotion getPromotionByPromoid() {
        return promotionByPromoid;
    }

    public void setPromotionByPromoid(Promotion promotionByPromoid) {
        this.promotionByPromoid = promotionByPromoid;
    }
}
