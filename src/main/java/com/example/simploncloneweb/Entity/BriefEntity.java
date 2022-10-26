package com.example.simploncloneweb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brief", schema = "public", catalog = "simplonCloneWeb")
public class BriefEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "context")
    private String context;
    @Basic
    @Column(name = "deadline")
    private long deadline;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BriefEntity that = (BriefEntity) o;

        if (id != that.id) return false;
        if (deadline != that.deadline) return false;
        if (context != null ? !context.equals(that.context) : that.context != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (int) (deadline ^ (deadline >>> 32));
        return result;
    }
}
