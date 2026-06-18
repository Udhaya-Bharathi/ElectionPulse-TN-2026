package com.project.electionpulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Constituency")
public class Constituency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer acNumber;

    private String name;

    private String seatCategory;

    @ManyToOne
    @JoinColumn(name="district_id")
    private District district;

    public Constituency(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAcNumber() {
        return acNumber;
    }

    public void setAcNumber(Integer acNumber) {
        this.acNumber = acNumber;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
