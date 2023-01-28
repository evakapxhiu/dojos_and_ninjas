package com.betaplan.eva.dojosandninjas.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="dojos")
public class Dojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 200)
    private String location;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

    @PrePersist
    protected void onCreate(){
        this.createdAt=new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt=new Date();
    }
    public Dojo() {
    }

    public Dojo(Long id, String location, Date createdAt, Date updatedAt, List<Ninja> ninjas) {
        this.id = id;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ninjas = ninjas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }
}
