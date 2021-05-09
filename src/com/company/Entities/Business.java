package com.company.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Business {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public Set<Sellable> getSellables() {
        return sellables;
    }

    public void setSellables(Set<Sellable> sellables) {
        this.sellables = sellables;
    }

    private String name;
    private String CIF;
    private String location;
    private String registration_number;

    // cascade = {CascadeType.ALL },
    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "business_sellable"
            , joinColumns =  @JoinColumn(name = "business_id")
            //      , inverseJoinColumns = @JoinColumn(name = "sellable_id")
    )
    Set<Sellable> sellables = new HashSet<Sellable>();


    public Business(){}

    public Business(String name, String CIF, String location, String registrationnumber) {
        this.name = name;
        this.CIF = CIF;
        this.location = location;
        registration_number = registrationnumber;
    }

    public void AddSellable(Sellable sellable)
    {
        if(sellable == null)
            return;

        sellables.add(sellable);
        sellable.AddBusiness(this);
    }


    @Override
    public String toString() {
        return "Business{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", CIF" + CIF + '\'' +
                ", Registration Number='" + registration_number +
                "\'}";
    }


}