package com.example.simploncloneweb.Entity;

import jakarta.persistence.*;

@Entity
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
    @Column(name = "promoid")
    private Integer promoid;
    @ManyToOne
    @JoinColumn(name = "promoid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brief brief = (Brief) o;

        if (id != null ? !id.equals(brief.id) : brief.id != null) return false;
        if (context != null ? !context.equals(brief.context) : brief.context != null) return false;
        if (deadline != null ? !deadline.equals(brief.deadline) : brief.deadline != null) return false;
        if (promoid != null ? !promoid.equals(brief.promoid) : brief.promoid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (promoid != null ? promoid.hashCode() : 0);
        return result;
    }

    public Promotion getPromotionByPromoid() {
        return promotionByPromoid;
    }

    public void setPromotionByPromoid(Promotion promotionByPromoid) {
        this.promotionByPromoid = promotionByPromoid;
    }
}
